const Fournisseur = require('../models/fournisseur');

// @desc    Créer un nouveau fournisseur
// @route   POST /api/fournisseurs
// @access  Public
exports.creerFournisseur = async (req, res) => {
  try {
    const fournisseur = await Fournisseur.create(req.body);
    res.status(201).json({
      success: true,
      data: fournisseur
    });
  } catch (error) {
    res.status(400).json({
      success: false,
      message: error.message
    });
  }
};

// @desc    Récupérer tous les fournisseurs
// @route   GET /api/fournisseurs
// @access  Public
exports.getFournisseurs = async (req, res) => {
  try {
    const fournisseurs = await Fournisseur.find();
    res.status(200).json({
      success: true,
      count: fournisseurs.length,
      data: fournisseurs
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      message: error.message
    });
  }
};

// @desc    Récupérer un fournisseur spécifique par ID
// @route   GET /api/fournisseurs/:id
// @access  Public
exports.getFournisseur = async (req, res) => {
  try {
    const fournisseur = await Fournisseur.findById(req.params.id);

    if (!fournisseur) {
      return res.status(404).json({
        success: false,
        message: `Fournisseur non trouvé avec l'ID ${req.params.id}`
      });
    }

    res.status(200).json({
      success: true,
      data: fournisseur
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      message: error.message
    });
  }
};

// @desc    Récupérer un fournisseur par email
// @route   GET /api/fournisseurs/email/:email
// @access  Public
exports.getFournisseurByEmail = async (req, res) => {
  try {
    const fournisseur = await Fournisseur.findOne({ email: req.params.email });

    if (!fournisseur) {
      return res.status(404).json({
        success: false,
        message: `Fournisseur non trouvé avec l'email ${req.params.email}`
      });
    }

    res.status(200).json({
      success: true,
      data: fournisseur
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      message: error.message
    });
  }
};

// @desc    Mettre à jour un fournisseur
// @route   PUT /api/fournisseurs/:id
// @access  Public
exports.updateFournisseur = async (req, res) => {
  try {
    const fournisseur = await Fournisseur.findByIdAndUpdate(
      req.params.id,
      req.body,
      {
        new: true,
        runValidators: true
      }
    );

    if (!fournisseur) {
      return res.status(404).json({
        success: false,
        message: `Fournisseur non trouvé avec l'ID ${req.params.id}`
      });
    }

    res.status(200).json({
      success: true,
      data: fournisseur
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      message: error.message
    });
  }
};

// @desc    Supprimer un fournisseur
// @route   DELETE /api/fournisseurs/:id
// @access  Public
exports.deleteFournisseur = async (req, res) => {
  try {
    const fournisseur = await Fournisseur.findByIdAndDelete(req.params.id);

    if (!fournisseur) {
      return res.status(404).json({
        success: false,
        message: `Fournisseur non trouvé avec l'ID ${req.params.id}`
      });
    }

    res.status(200).json({
      success: true,
      data: {}
    });
  } catch (error) {
    res.status(500).json({
      success: false,
      message: error.message
    });
  }
};

