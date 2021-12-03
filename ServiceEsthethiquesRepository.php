<?php

namespace App\Repository;

use App\Entity\ServiceEsthethiques;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Doctrine\ORM\EntityRepository;

/**
 * @method ServiceEsthethiques|null find($id, $lockMode = null, $lockVersion = null)
 * @method ServiceEsthethiques|null findOneBy(array $criteria, array $orderBy = null)
 * @method ServiceEsthethiques[]    findAll()
 * @method ServiceEsthethiques[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class ServiceEsthethiquesRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, ServiceEsthethiques::class);
    }

    // /**
    //  * @return ServiceEsthethiques[] Returns an array of ServiceEsthethiques objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('s')
            ->andWhere('s.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('s.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?ServiceEsthethiques
    {
        return $this->createQueryBuilder('s')
            ->andWhere('s.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
