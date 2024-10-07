<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Simulation de Crédit Bancaire</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
  <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/logo.png">
</head>
<body>
<!-- Main Header -->
<header class="main-header">
  <div class="logo">
    <img src="${pageContext.request.contextPath}/images/logo.png" alt="Wafa Salaf">
  </div>
  <nav class="main-nav">
    <ul>
      <li><a href="#">Mes besoins</a></li>
      <li><a href="#">Mes promotions</a></li>
      <li><a href="#">Guides pratiques</a></li>
      <li><a href="#">Découvrir Wafasalaf</a></li>
      <li><a href="#">Régler mes impayés</a></li>
    </ul>
  </nav>
  <div class="account">
    <a href="#" class="account-btn">
      Mon compte
    </a>
  </div>
</header>

<!-- Breadcrumb -->
<nav class="breadcrumb">
  <a href="#">Accueil</a> / <span>Demander mon crédit en ligne</span>
</nav>

<h1>Demander mon crédit en ligne</h1>
<div class="container">
  <div class="simulator">
    <div class="steps">
      <div class="step active">
        <div class="step-one">1</div>
        <div class="step-title">Simuler mon crédit</div>
      </div>
      <div class="step">
        <div class="step-two">2</div>
        <div class="step-title">Mes coordonnées</div>
      </div>
      <div class="step">
        <div class="step-three">3</div>
        <div class="step-title">Mes infos personnelles</div>
      </div>
    </div>
    <div class="form">
      <form id="creditForm">
        <div class="form-group">
          <label for="project">Mon projet</label>
          <select id="project" required>
            <option>J'ai besoin de l'argen</option>
            <option>Je finance mon véhicule d'occasion</option>
            <option>Je gère mes imprévus</option>
            <option>Je finance mon vehicule neuf</option>
            <option>J'équipe ma maison</option>
          </select>
        </div>
        <div class="form-group">
          <label for="status">Je suis</label>
          <select id="status" required>
            <option>Salarié du secteur privé</option>
            <option>Fonctionnaire</option>
            <option>Profession libérale</option>
            <option>Commerçant</option>
            <option>Artisan</option>
            <option>Retraité</option>
            <option>Autres Professions</option>
          </select>
        </div>
        <div class="form-group">
          <label for="amount">Montant (en DH)</label>
          <input type="number" id="amount" value="5000" required />
          <input
                  type="range"
                  id="amountRange"
                  min="1000"
                  max="1000000"
                  value="5000"
                  step="1000"
          />
        </div>
        <div class="form-group">
          <label for="duration">Durée (en mois)</label>
          <input type="number" id="duration" value="120" required />
          <input
                  type="range"
                  id="durationRange"
                  min="12"
                  max="240"
                  value="120"
                  step="12"
          />
        </div>
        <div class="form-group">
          <label for="monthly">Mensualités (en DH)</label>
          <input type="number" id="monthly" value="70.91" required />
          <input
                  type="range"
                  id="monthlyRange"
                  min="10"
                  max="10000"
                  value="70.91"
                  step="0.01"
          />
        </div>
        <div class="btn">
          <button type="submit" class="btn-continue">
            Continuer
            <span class="btn-subtext">Sans engagement</span>
          </button>
        </div>
      </form>
    </div>
    <div class="loi">
      <p>Simulation à titre indicatif et non contractuelle. La mensualité minimale est de 180 dirhams. Un client Wafasalaf peut bénéficier d'une tarification plus avantageuse en fonction de ses conditions préférentielles.</p>
      <p>Conformément à la loi 09-08, vous disposez d’un droit d’accès, de rectification et d’opposition au traitement de vos données personnelles. Ce traitement est autorisé par la CNDP sous le numéro A-GC-206/2014.</p>
    </div>
  </div>
  <div class="summary">
    <h2 class="title">Mon récapitulatif</h2>
    <h3 class="mon-projet">Mon projet</h3>
    <p class="pret-persnl" id="summaryProject">Prêt Personnel</p>
  </div>
</div>

<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>