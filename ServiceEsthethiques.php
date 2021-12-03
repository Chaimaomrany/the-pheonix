<?php

namespace App\Entity;
use Symfony\Component\Validator\Constraints as Assert;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\HttpFoundation\File\File;

/**
 * ServiceEsthethiques
 *
 * @ORM\Table(name="service_esthethiques")
 * @ORM\Entity
 */
class ServiceEsthethiques
{
    /**
     * @var int
     *
     * @ORM\Column(name="ref_s_esth", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $refSEsth;
    /*
    /**
     * @var string|null
     * @ORM\Column(type="string" , length=255)
     */
    /*private $filename;

    /**
     * @var File|null
     * @Vich\UploadableField(mapping="service_image", fileNameProperty="filename")
     */
    /*private $imageFile; */
    /**
     * @var int
     *
     * @ORM\Column(name="prix_s_esth", type="integer", nullable=false)
     */
    private $prixSEsth;

    /**
     * @var string
     *
     * @ORM\Column(name="nol_s_esth", type="string", length=255, nullable=false)
     */
    private $nolSEsth;

    public function getRefSEsth(): ?int
    {
        return $this->refSEsth;
    }

    public function getPrixSEsth(): ?int
    {
        return $this->prixSEsth;
    }

    public function setPrixSEsth(int $prixSEsth): self
    {
        $this->prixSEsth = $prixSEsth;

        return $this;
    }

    public function getNolSEsth(): ?string
    {
        return $this->nolSEsth;
    }

    public function setNolSEsth(string $nolSEsth): self
    {
        $this->nolSEsth = $nolSEsth;

        return $this;
    }



}
