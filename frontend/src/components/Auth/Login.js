import { useState, useContext } from 'react';
import { AuthContext } from '../context/AuthContext';
import { login as apiLogin } from '../api/auth'; // Renommé pour éviter le conflit

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null); // Utilisation de l'erreur
  const { login: contextLogin } = useContext(AuthContext); // Renommé pour clarté

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(null); // Réinitialise l'erreur à chaque soumission
    
    try {
      // Appel à la fonction d'API renommée
      const { token } = await apiLogin(email, password);
      // Utilisation de la fonction du contexte
      contextLogin(token);
      alert('Connexion réussie!');
    } catch (err) {
      setError(err.response?.data?.message || 'Erreur de connexion');
      alert(error); // Affiche l'erreur proprement
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="Email"
          required
        />
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          placeholder="Mot de passe"
          required
        />
        <button type="submit">Se connecter</button>
      </form>
      {error && <p style={{ color: 'red' }}>{error}</p>}
    </div>
  );
}