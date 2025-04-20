const mongoose = require('mongoose');

const fournisseurSchema = new mongoose.Schema({
  nom: {
    type: String,
    required: [true, 'Le nom du fournisseur est obligatoire'],
    trim: true
  },
  email: {
    type: String,
    required: [true, 'L\'email du fournisseur est obligatoire'],
    trim: true,
    lowercase: true,
    match: [/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/, 'Veuillez fournir un email valide']
  },
  telephone: {
    type: String,
    required: [true, 'Le numéro de téléphone est obligatoire'],
    trim: true
  },
  adresse: {
    type: String,
    required: [true, 'L\'adresse est obligatoire'],
    trim: true
  },
  produitIds: {
    type: [Number],
    default: []
  },
  delaiLivraisonMoyen: {
    type: Number,
    default: 0
  },
  noteFiabilite: {
    type: Number,
    min: [1, 'La note de fiabilité doit être au minimum 1'],
    max: [5, 'La note de fiabilité doit être au maximum 5'],
    default: 3
  }
}, {
  timestamps: true
});

const Fournisseur = mongoose.model('Fournisseur', fournisseurSchema);

module.exports = Fournisseur;
