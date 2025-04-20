const express = require('express');
const dotenv = require('dotenv');
const connectDB = require('./config/db');

// Charger les variables d'environnement
dotenv.config();

// Connexion à la base de données
connectDB();

const app = express();
const port = process.env.PORT || 3000;

// Middleware pour parser les requêtes JSON
app.use(express.json());

// Route de base
app.get('/', (req, res) => {
  res.send('Bienvenue sur mon serveur Express !');
});

// Routes pour les fournisseurs
app.use('/api/fournisseurs', require('./routes/fournisseurRoutes'));

// Démarrer le serveur
app.listen(port, () => {
  console.log(`Serveur démarré sur http://localhost:${port}`);
});