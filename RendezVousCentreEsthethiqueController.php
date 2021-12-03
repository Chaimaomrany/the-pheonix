<?php

namespace App\Controller;

use App\Entity\RendezVousCentreEsthethique;
use App\Form\RendezVousCentreEsthethiqueType;
use App\Repository\RendezVousCentreEsthethiqueRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\Mime\Email;

class RendezVousCentreEsthethiqueController extends AbstractController
{
    /**
     * @Route("/rendez/vous/centre/esthethique", name="rendez_vous_centre_esthethique")
     */
    public function index(): Response
    {
        return $this->render('rendez_vous_centre_esthethique/index.html.twig', [
            'controller_name' => 'RendezVousCentreEsthethiqueController',
        ]);
    }
    /**
     * @param RendezVousCentreEsthethiqueRepository $repository
     * @return Symfony\Component\HttpFoundation\Response
     * @Route ("service_esthethiques/Affiche" ,name="AFF")
     */
    function Affiche(RendezVousCentreEsthethiqueRepository $repository ){
        //$repo=$this->getDoctrine()->getRepository(Classroom::class);
        $rendezvouscentreesthethique=$repository->findAll();
        return $this->render('rendez_vous_centre_esthethique/Affiche.html.twig',
            [
                'cc'=>$rendezvouscentreesthethique
            ]);
        $rendezvouscentreesthethique = $this->getDoctrine()->getRepository(RendezVousCentreEsthethique::class)->findBy([], ['created_at' => 'desc']);
    }

    /**

     * @Route ("/",name="page")
     */
    function Afficheb( ){

        return $this->render('rendez_vous_centre_esthethique/Service.html.twig');

    }
    /**

     * @Route ("/service_esthethiques/bienvenu")
     */
    function Affichef( ){

        return $this->render('rendez_vous_centre_esthethique/index.html.twig');

    }


    /**
     * @param $id
     * @param RendezVousCentreEsthethiqueRepository$rep
     * @Route ("/Delete/{id}", name="dd")
     */
    function Delete($id,RendezVousCentreEsthethiqueRepository $rep){
        $rendezvouscentreesthethique=$rep->find($id);
        $em=$this->getDoctrine()->getManager();
        $em->remove($rendezvouscentreesthethique);
        $em->flush();
        return $this->redirectToRoute('AFF');

    }
    /**
     * @param Request $request
     * @return Symfony\Component\HttpFoundation\Response
     * @Route ("rendez_vous_centre_esthethique/Ajout")
     */
    function Ajout(Request $request, MailerInterface $mailer){
        $rendezvouscentreesthethique=new RendezVousCentreEsthethique();
        $form=$this->createForm(RendezVousCentreEsthethiqueType::class,$rendezvouscentreesthethique);

        $form->handleRequest($request);
        if($form->isSubmitted() && $form->isValid()){
            $em=$this->getDoctrine()->getManager();
            $em->persist($rendezvouscentreesthethique);
            $em->flush();
            $email = (new Email())
                ->from('tabaani.app@gmail.com')
                ->to($rendezvouscentreesthethique->getEmail())
                //->cc('cc@example.com')
                //->bcc('bcc@example.com')
                //->replyTo('fabien@example.com')
                //->priority(Email::PRIORITY_HIGH)
                ->subject('Rendez vous!')
                ->text('Sending emails is fun again!')
                ->html('<p>Votre render vous est confirmé!</p>');

            $mailer->send($email);
            return $this->redirectToRoute('page');

        }
        return $this->render('rendez_vous_centre_esthethique/Ajout.html.twig',
            ['f'=>$form->createView()]);

    }
    /**
     * @Route("rendez_vous_centre_esthethique/Update/{id}",name="updatee")
     */
    function Update(RendezVousCentreEsthethiqueRepository $repository,$id,Request $request)
    {
        $rendezvouscentreesthethique = $repository->find($id);
        $form = $this->createForm(RendezVousCentreEsthethiqueType::class, $rendezvouscentreesthethique);
        $form->add('Update', SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute('AFF');
        }
        return $this->render('rendez_vous_centre_esthethique/Update.html.twig',
            [
                'f' => $form->createView(),
                "form_title" => "Modifier un rendez_vous_centre_esthethique"
            ]);
    }


    /**
     * @Route ("search/", name="S")
     */
    function Search(RendezVousCentreEsthethiqueRepository $repository,Request $request){
        $data=$request->get('a');
        $rendezvouscentreesthethique=$repository->findBy(['id'=>$data]);
        return $this->render('rendez_vous_centre_esthethique/Affiche.html.twig',
            ['cc'=>$rendezvouscentreesthethique]);
    }
    /**
     * @param RendezVousCentreEsthethiqueRepository $repository
     * @return Response
     * @Route ("service_esthethiques/affichedate")
     */
    function AfficheDate(RendezVousCentreEsthethiqueRepository  $repository){
        $rendezvouscentreesthethique=$repository->OrderByDate();
        return $this->render('rendez_vous_centre_esthethique/Affiche.html.twig',
            ['cc'=>$rendezvouscentreesthethique]);

    }
    /**
     * @Route ("service_esthethiques/searchc", name="S")
     */
    function Searchbyclass(RendezVousCentreEsthethiqueRepository $repository,Request $request){
        $data=$request->get('i');
        $rendezvouscentreesthethique=$repository->ListByClass(['id'=>$data]);
        $ct = count($rendezvouscentreesthethique);
        return $this->render('rendez_vous_centre_esthethique/Affiche.html.twig',
            ['cc'=>$rendezvouscentreesthethique]);
    }

}
