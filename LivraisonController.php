<?php

namespace App\Controller;

use App\Entity\Livraison;
use App\Entity\Recherche;
use App\Form\LivraisonType;
use App\Form\RechercheType;
use App\Repository\LivraisonRepository;
use App\Repository\RechercheRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Mailer\MailerInterface;
use Symfony\Component\Mime\Email;
use Dompdf\Dompdf;
use Dompdf\Options;
use Symfony\Component\Form\Extension\Core\Type\TextType;
/**
 * @Route("/livraison")
 */
class LivraisonController extends AbstractController
{
    /**
     * @Route("/", name="livraison_index")
     */
   /* public function index(EntityManagerInterface $entityManager): Response
    {

        $livraisons = $entityManager
            ->getRepository(Livraison::class)
            ->findAll();


            return $this->render('livraison/index.html.twig', [
            'livraisons' => $livraisons,
        ]);
    }*/


    public function home(Request $request, LivraisonRepository $livraisonRepository )
    {
        $recherche = new Recherche();
        $form = $this->createForm(RechercheType::class,$recherche);
        $form->handleRequest($request);
        //initialement le tableau des articles est vide,
        //c.a.d on affiche les articles que lorsque l'utilisateur
        //clique sur le bouton rechercher
        $livraison= $livraisonRepository->findAll();;

        if($form->isSubmitted() && $form->isValid()) {
            //on récupère le nom d'article tapé dans le formulaire
            $nomlivreur = $recherche->getNomlivreur();
            if ($nomlivreur!="")
                //si on a fourni un nom d'article on affiche tous les articles ayant ce nom
                $livraison= $this->getDoctrine()->getRepository(Livraison::class)->findBy(['nomlivreur' => $nomlivreur] );
            else
                //si si aucun nom n'est fourni on affiche tous les articles
                $user= $this->getDoctrine()->getRepository(Livraison::class)->findAll();
        }
        return $this->render('livraison/index.html.twig',[ 'form' =>$form->createView(),
            'livraisons' => $livraison ]);
    }





    /*
     * **************************************************************************************************
     */

    /*
     * **************************************************************************
     * */


    /**
     * @Route("/listLivraison", name="livraison_imprime", methods={"GET"})
     */
    public function imprimer(LivraisonRepository $livraisonRepository): Response
    {

        // Configure Dompdf according to your needs
        $pdfOptions = new Options();
        $pdfOptions->set('defaultFont', 'Arial');

        // Instantiate Dompdf with our options
        $dompdf = new Dompdf($pdfOptions);
        $livraisons = $livraisonRepository ->findAll();

        return $this->render('livraison/listLivraison.html.twig', [
            'livraisons' => $livraisons,
        ]);

        // Retrieve the HTML generated in our twig file
        $html = $this->renderView('livraison/listLivraison.html.twig', [
            'livraisons' => $livraisons,
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

    }




    /*
 * **************************************************************************
 * */




    /**
     * @Route("/new", name="livraison_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager, MailerInterface $mailer): Response
    {
        $livraison = new Livraison();
        $form = $this->createForm(LivraisonType::class, $livraison);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($livraison);
            $entityManager->flush();



            $email = (new Email())
                ->from('tabaani.app@gmail.com')
                ->to($livraison->getEmail())
                //->cc('cc@example.com')
                //->bcc('bcc@example.com')
                //->replyTo('fabien@example.com')
                //->priority(Email::PRIORITY_HIGH)
                ->subject('Confirmation de livraison !')
                ->text('Sending emails is fun again!')
                ->html('<p>Vous recevrez votre livraison dans 3 jours    Merci!</p>');

            $mailer->send($email);

            return $this->redirectToRoute('livraison_index', [], Response::HTTP_SEE_OTHER);
        }



        return $this->render('livraison/new.html.twig', [
            'livraison' => $livraison,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idliv}", name="livraison_show", methods={"GET"})
     */
    public function show(Livraison $livraison): Response
    {
        return $this->render('livraison/show.html.twig', [
            'livraison' => $livraison,
        ]);
    }

    /**
     * @Route("/{idliv}/edit", name="livraison_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Livraison $livraison, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(LivraisonType::class, $livraison);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('livraison_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('livraison/edit.html.twig', [
            'livraison' => $livraison,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{idliv}", name="livraison_delete", methods={"POST"})
     */
    public function delete(Request $request, Livraison $livraison, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$livraison->getIdliv(), $request->request->get('_token'))) {
            $entityManager->remove($livraison);
            $entityManager->flush();
        }

        return $this->redirectToRoute('livraison_index', [], Response::HTTP_SEE_OTHER);
    }




}
