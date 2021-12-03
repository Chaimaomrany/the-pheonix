<?php

namespace App\Repository;

use App\Entity\RendezVousCentreEsthethique;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;
use Doctrine\ORM\EntityRepository;
/**
 * @method RendezVousCentreEsthethique|null find($id, $lockMode = null, $lockVersion = null)
 * @method RendezVousCentreEsthethique|null findOneBy(array $criteria, array $orderBy = null)
 * @method RendezVousCentreEsthethique[]    findAll()
 * @method RendezVousCentreEsthethique[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class RendezVousCentreEsthethiqueRepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, RendezVousCentreEsthethique::class);
    }

    // /**
    //  * @return RendezVousCentreEsthethique[] Returns an array of RendezVousCentreEsthethique objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('r')
            ->andWhere('r.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('r.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?RendezVousCentreEsthethique
    {
        return $this->createQueryBuilder('r')
            ->andWhere('r.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
    function OrderByDate()
    {
        return $this->createQueryBuilder('r')
           /* ->where('r.date >= CURRENT_DATE()') */
           /* ->orderBy('r.date','ASEC')*/

            ->setMaxResults(2)
            ->getQuery()->getResult();
    }
    function ListByClass($c){
        return $this->createQueryBuilder('s')
            ->join('s.idService','c')
            ->addSelect('c')
            ->where('c.refSEsth=:i')
            ->setParameter('i', $c)
            ->getQuery()->getResult()
            ;
    }
}
