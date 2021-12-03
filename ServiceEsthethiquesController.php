<?php

namespace App\Controller;

use App\Entity\ServiceEsthethiques;
use App\Form\ServiceType;
use App\Repository\ServiceEsthethiquesRepository;
use Doctrine\Persistence\ObjectManager;
use Faker\Factory;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ServiceEsthethiquesController extends AbstractController
{
    /**
     * @Route("service_esthethiques", name="service_esthethiques")
     */
    public function index(ServiceEsthethiquesRepository $repository): Response
    {
        $service =$repository->findAll();
        return $this->render('service_esthethiques/index.html.twig', [
            'controller_name' => 'ServiceEsthethiquesController',

                'cc' => $service

        ]);
    }

    /**
     * @param ServiceEsthethiquesRepository $repository
     * @return Symfony\Component\HttpFoundation\Response
     * @Route ("service_esthethiques/Affichee", name="AF")
     */
    function Affiche(ServiceEsthethiquesRepository $repository)
    {
        //$repo=$this->getDoctrine()->getRepository(Classroom::class);
        $service = $repository->findAll();
        return $this->render('service_esthethiques/Affiche.html.twig',
            [
                'cc' => $service
            ]);
        $service = $this->getDoctrine()->getRepository(ServiceEsthethiques::class)->findBy([], ['created_at' => 'desc']);
    }

    /**
     * @param $id
     * @param ServiceEsthethiquesRepository\ $rep
     * @Route ("service_esthethiques/Delete/{id}", name="d")
     */
    function Delete($id, ServiceEsthethiquesRepository $rep)
    {
        $service = $rep->find($id);
        $em = $this->getDoctrine()->getManager();
        $em->remove($service);
        $em->flush();
        return $this->redirectToRoute('AF');

    }

    /**
     * @param Request $request
     * @return Symfony\Component\HttpFoundation\Response
     * @Route("service_esthethiques/Ajout",name="A")
     */
    function Ajout(Request $request)
    {
        $service = new ServiceEsthethiques();
        $form = $this->createForm(ServiceType::class, $service);

        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($service);
            $em->flush();
            return $this->redirectToRoute('AF');

        }
        return $this->render('service_esthethiques/Ajout.html.twig',
            ['f' => $form->createView()]);

    }
    /**
     * @param ProduitRepository $repository
     * @return Response
     * @Route ("service_esthethiques/affich")
     */
    function Afficheee(ServiceEsthethiquesRepository $repository, Request $request ){

        $service=$repository->findAll();



        return $this->render('service_esthethiques/index.html.twig',['service'=>$service]);

 $service = $this->getDoctrine()->getRepository(ServiceEsthethiques::class)->findBy([], ['created_at' => 'desc']);
    }

    /**
     * @Route("service_esthethiques/Update/{id}",name="update")
     */
    function Update(ServiceEsthethiquesRepository $repository, $id, Request $request)
    {
        $service = $repository->find($id);
        $form = $this->createForm(ServiceType::class, $service);
        $form->add('Update', SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute("AF");
        }
        return $this->render('service_esthethiques/Update.html.twig',
            [
                'f' => $form->createView(),
                "form_title" => "Modifier un service_esthethiques"
            ]);

    }






}