<?php
include './phpqrcode/qrlib.php';
QRcode::png('web mob tuts');
$idProduit = $_GET['idProduit'];
$code = "web mob tuts - $idProduit";
QRcode::png($code);