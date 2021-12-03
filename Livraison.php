<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Livraison
 *
 * @ORM\Table(name="livraison")
 * @ORM\Entity(repositoryClass="App\Repository\LivraisonRepository")
 */
class Livraison
{
    /**
     * @var int
     *
     * @ORM\Column(name="idliv", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idliv;

    /**
     * @var string
     * @ Assert\NotBlank()
     * @ORM\Column(name="nomlivreur", type="string", length=255, nullable=false)
     */
    private $nomlivreur;

    /**
     * @var string
     * @ Assert\NotBlank()
     * @ORM\Column(name="nomclient", type="string", length=255, nullable=false)
     */
    private $nomclient;

    /**
     * @var int
     * @ Assert\NotBlank()
     * @ORM\Column(name="numTelClient", type="integer", nullable=false)
     */
    private $numtelclient;

    /**
     * @var string
     * @ Assert\NotBlank()
     * @ORM\Column(name="lieudepart", type="string", length=255, nullable=false)
     */
    private $lieudepart;

    /**
     * @var string
     * @ Assert\NotBlank()
     * @ORM\Column(name="destination", type="string", length=255, nullable=false)
     */
    private $destination;

    /**
     * @var \DateTime
     * @ Assert\NotBlank()
     * @ORM\Column(name="dateliv", type="date", nullable=false)
     */
    private $dateliv;

    /**
     * @var string
     * @ Assert\NotBlank()
     * @ORM\Column(name="email", type="string", length=255, nullable=false)
     */
    private $email;

    public function getIdliv(): ?int
    {
        return $this->idliv;
    }

    public function getNomlivreur(): ?string
    {
        return $this->nomlivreur;
    }

    public function setNomlivreur(string $nomlivreur): self
    {
        $this->nomlivreur = $nomlivreur;

        return $this;
    }

    public function getNomclient(): ?string
    {
        return $this->nomclient;
    }

    public function setNomclient(string $nomclient): self
    {
        $this->nomclient = $nomclient;

        return $this;
    }

    public function getNumtelclient(): ?int
    {
        return $this->numtelclient;
    }

    public function setNumtelclient(int $numtelclient): self
    {
        $this->numtelclient = $numtelclient;

        return $this;
    }

    public function getLieudepart(): ?string
    {
        return $this->lieudepart;
    }

    public function setLieudepart(string $lieudepart): self
    {
        $this->lieudepart = $lieudepart;

        return $this;
    }

    public function getDestination(): ?string
    {
        return $this->destination;
    }

    public function setDestination(string $destination): self
    {
        $this->destination = $destination;

        return $this;
    }

    public function getDateliv(): ?\DateTimeInterface
    {
        return $this->dateliv;
    }

    public function setDateliv(\DateTimeInterface $dateliv): self
    {
        $this->dateliv = $dateliv;

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


}
