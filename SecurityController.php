<?php

namespace App\Controller;

use App\Form\LoginType;
use App\Form\RegistrationType;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use Doctrine\Persistence\ObjectManager;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use App\Entity\User;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;


class SecurityController extends AbstractController
{
    /**
     * @Route("/inscription", name="security_registration")
     *
     */
    public function registration(Request $request, EntityManagerInterface $entityManager,
                                 UserPasswordEncoderInterface  $encoder, MailerInterface $mailer): Response
    {
        $user = new User();
        $form = $this->createForm(RegistrationType::class, $user);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $hash = $encoder->encodePassword($user, $user->getMdp());

            $user->setMdp($hash);

            $entityManager->persist($user);
            $entityManager->flush();

            $email = (new Email())
                ->from('tabaani.app@gmail.com')
                ->to($user->getMail())
                //->cc('cc@example.com')
                //->bcc('bcc@example.com')
                //->replyTo('fabien@example.com')
                //->priority(Email::PRIORITY_HIGH)
                ->subject('Confirmation d Inscription!')
                ->text('Sending emails is fun again!')
                ->html('<p>Bienvenue dans notre Application    Merci!</p>');

            $mailer->send($email);
            return $this->redirectToRoute('security_login', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('security/registration.html.twig', [
            'user' => $user,
            'form' => $form->createView(),
        ]);
    }


    /**
     * @param AuthenticationUtils $authenticationUtils
     * @return Response
     * @Route("/connexion", name="security_login")
     */
    public function login(AuthenticationUtils $authenticationUtils): Response
    {
        // if ($this->getUser()) {
        //     return $this->redirectToRoute('target_path');
        // }

        // get the login error if there is one
        $error = $authenticationUtils->getLastAuthenticationError();
        // last username entered by the user
        $lastUsername = $authenticationUtils->getLastUsername();

        return $this->render('security/login.html.twig', ['last_username' => $lastUsername, 'error' => $error]);
    }


    /*public function login(){
        return $this->render('security/login.html.twig');
    }*/
  /*  /**
     * @param Request $request
     * @param UserRepository $repository
     * @return Response
     * @Route("/login", name="security_login")
     */
  /*  public function login(Request $request,userRepository $repository): Response
    {
        $session = $request->getSession();
        if($session->get('mail')!=null){
            return $this->redirectToRoute('user');
        }
        $user = new User();
        $form = $this->createForm(LoginType::class, $user);
        $form->handleRequest($request);
        $email = $repository->findOneBy(['mail' => $user->getMail()]);

        return $this->render('security/login.html.twig', ['controller_name' => 'SecurityController',
            'form'=>$form->createView(),
        ]);
    }*/



    /* public function registration(Request $request, ObjectManager $manager)
     {

         $user = new user();
         $request = new Request();


         $form = $this->createForm(RegistrationType::class, $user);

         $form->handleRequest($request);

         if($form->isSubmitted() && $form->isValid()){
             $manager->persist($user);
             $manager->flush();
         }

         return $this->render('security/registration.html.twig', [
            'form' => $form->createView()
         ]);
     }*/
}
