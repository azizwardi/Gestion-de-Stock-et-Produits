const express = require('express');
const router = express.Router();
const {
  creerFournisseur,
  getFournisseurs,
  getFournisseur,
  getFournisseurByEmail,
  updateFournisseur,
  deleteFournisseur
} = require('../controllers/fournisseurController');

router.route('/')
  .get(getFournisseurs)
  .post(creerFournisseur);

router.route('/:id')
  .get(getFournisseur)
  .put(updateFournisseur)
  .delete(deleteFournisseur);

router.route('/email/:email')
  .get(getFournisseurByEmail);

module.exports = router;