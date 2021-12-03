<?php

namespace App\Entity;
use Symfony\Component\Validator\Constraints as Assert;
use Doctrine\ORM\Mapping as ORM;

/**
 * RendezVousCentreEsthethique
 *
 * @ORM\Table(name="rendez_vous_centre_esthethique", indexes={@ORM\Index(name="id_service", columns={"id_service"})})
 * @ORM\Entity
 */
class RendezVousCentreEsthethique
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var \DateTime

     * @ORM\Column(name="h_debut", type="time", nullable=false)
     */
    private $hDebut;

    /**
     * @var \DateTime
     *  * @Assert\Expression(
     *     "this.getHDebut() < this.getHFin()",
     *     message="l'heure fin ne doit pas etre anterier a l'heure debut"
     * )

     * @ORM\Column(name="h_fin", type="time", nullable=false)
     */
    private $hFin;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="datetime", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=255, nullable=false)
     */
    private $email;

    /**
     * @var int
     *
     * @ORM\Column(name="tel", type="integer", nullable=false)
     */
    private $tel;

    /**
     * @var \ServiceEsthethiques
     *
     * @ORM\ManyToOne(targetEntity="ServiceEsthethiques")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_service", referencedColumnName="ref_s_esth")
     * })
     */
    private $idService;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getHDebut(): ?\DateTimeInterface
    {
        return $this->hDebut;
    }

    public function setHDebut(\DateTimeInterface $hDebut): self
    {
        $this->hDebut = $hDebut;

        return $this;
    }

    public function getHFin(): ?\DateTimeInterface
    {
        return $this->hFin;
    }

    public function setHFin(\DateTimeInterface $hFin): self
    {
        $this->hFin = $hFin;

        return $this;
    }

    public function getDate(): ?\DateTimeInterface
    {
        return $this->date;
    }

    public function setDate(\DateTimeInterface $date): self
    {
        $this->date = $date;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getTel(): ?int
    {
        return $this->tel;
    }

    public function setTel(int $tel): self
    {
        $this->tel = $tel;

        return $this;
    }

    public function getIdService(): ?ServiceEsthethiques
    {
        return $this->idService;
    }

    public function setIdService(?ServiceEsthethiques $idService): self
    {
        $this->idService = $idService;

        return $this;
    }


}
