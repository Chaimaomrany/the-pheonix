<?php

namespace App\Controller;

use App\Entity\RendezVousCentreEsthethique;
use App\Repository\RendezVousCentreEsthethiqueRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class CalenderController extends AbstractController
{
    /**
     * @Route("/service_esthethiques/index", name="calender")
     */
    public function index(RendezVousCentreEsthethiqueRepository $rendezVousCentreEsthethiqueRepository):Response
    {
    $events = $rendezVousCentreEsthethiqueRepository->findAll();
        $rdvs=[];
        foreach ($events as $event){
            $rdvs[]= [
                'nom'=> $event->getNom(),
                /*'id'=> $event->getId(),*/
                'date'=> $event->getDate()->format('Y-m-d H:i:s'),
                'hdebut'=> $event->getHDebut()->format('m'),
                'hfin'=> $event->getHFin()->format(' m'),
                /*'email'=> $event->getEmail(),
                'tel'=> $event->getTel(),*/

            ];}
        $data = json_encode($rdvs);
        return $this->render('calender/index.html.twig',compact('data'));



    }

}
