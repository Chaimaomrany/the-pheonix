<?php

namespace App\Form;

use App\Entity\Categorie;
use App\Entity\Produit;
use phpDocumentor\Reflection\File;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class ProduitType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('prix')
            ->add('categorie',EntityType::class,
                ['class'=>Categorie::class,
                    'choice_label'=>'nom'])

            ->add('nom')
            ->add ('imageFile', FileType::class,[
                'required'=>false
                ]
            )
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Produit::class,
        ]);
    }
}
