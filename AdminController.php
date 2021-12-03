<?php

namespace App\Controller;

use App\Entity\User;
use App\Form\User1Type;
use App\Repository\UserRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;
use App\Entity\PropertySearch;
use App\Form\PropertySearchType;
use Dompdf\Dompdf;
use Dompdf\Options;


/**
 * @Route("/admin")
 */
class AdminController extends AbstractController
{
    /*/**
     * @Route("/", name="admin_index", methods={"GET"})
     */

    /* public function index(UserRepository $userRepository): Response
    {
        return $this->render('admin/index.html.twig', [
            'users' => $userRepository->findAll(),
        ]);
    }*/

    /**
     * @Route("/" , name="admin_index" )
     */
    public function home(Request $request, UserRepository $userRepository)
    {
        $propertySearch = new PropertySearch();
        $form = $this->createForm(PropertySearchType::class, $propertySearch);
        $form->handleRequest($request);
        //initialement le tableau des articles est vide,
        //c.a.d on affiche les articles que lorsque l'utilisateur
        //clique sur le bouton rechercher
        $user = $userRepository->findAll();;

        if ($form->isSubmitted() && $form->isValid()) {
            //on récupère le nom d'article tapé dans le formulaire
            $nom = $propertySearch->getNom();
            if ($nom != "")
                //si on a fourni un nom d'article on affiche tous les articles ayant ce nom
                $user = $this->getDoctrine()->getRepository(User::class)->findBy(['nom' => $nom]);
            else
                //si si aucun nom n'est fourni on affiche tous les articles
                $user = $this->getDoctrine()->getRepository(User::class)->findAll();
        }
        return $this->render('admin/index.html.twig', ['form' => $form->createView(),
            'users' => $user]);
    }


    /**
     * @Route("/new", name="admin_new", methods={"GET", "POST"})
     */
    public function new(Request                      $request, EntityManagerInterface $entityManager,
                        UserPasswordEncoderInterface $encoder): Response
    {
        $user = new User();
        $form = $this->createForm(User1Type::class, $user);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $hash = $encoder->encodePassword($user, $user->getMdp());

            $user->setMdp($hash);

            $entityManager->persist($user);
            $entityManager->flush();

            return $this->redirectToRoute('admin_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('admin/new.html.twig', [
            'user' => $user,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="admin_show", methods={"GET"})
     */
    public function show(User $user): Response
    {
        return $this->render('admin/show.html.twig', [
            'user' => $user,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="admin_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, User $user, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(User1Type::class, $user);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('admin_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('admin/edit.html.twig', [
            'user' => $user,
            'form' => $form->createView(),
        ]);
    }


    /**
     * @Route("/{id}", name="admin_delete", methods={"POST"})
     */
    public function delete(Request $request, User $user, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete' . $user->getId(), $request->request->get('_token'))) {
            $entityManager->remove($user);
            $entityManager->flush();
        }

        return $this->redirectToRoute('admin_index', [], Response::HTTP_SEE_OTHER);
    }


  /*  /**
     * @Route("/pdf", name="admin_imprime", methods={"GET"})
     */
   /* public function print(UserRepository $userRepository): Response
    {

        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);
        $users = $userRepository->findAll();

        return $this->render('admin/pdf.html.twig', [
            'users' => $users,
        ]);

        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('admin/pdf.html.twig', [
            'users' => $users,
        ]);


        // Load HTML to Dompdf
        $dompdf->loadHtml($html);

        // (Optional) Setup the paper size and orientation 'portrait' or 'portrait'
        $dompdf->setPaper('A4', 'portrait');

        // Render the HTML as PDF
        $dompdf->render();

        // Output the generated PDF to Browser (force download)
        $dompdf->stream("mypdf.pdf", [
            "Attachment" => true
        ]);

    }*/


}
