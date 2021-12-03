<?php

namespace App\Form;

use App\Entity\RendezVousCentreEsthethique;
use App\Entity\ServiceEsthethiques;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class RendezVousCentreEsthethiqueType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('date')
            ->add('hDebut')
            ->add('hFin')
            ->add('nom')
            ->add('tel')
            ->add('email')
            ->add('idservice',EntityType::class,
                ['class'=>ServiceEsthethiques::class,
                    'choice_label'=>'nol_s_esth'])




        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => RendezVousCentreEsthethique::class,
        ]);
    }
}
