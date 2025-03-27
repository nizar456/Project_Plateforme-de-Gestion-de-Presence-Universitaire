import { createContext, useState } from 'react';
import { login as apiLogin } from '../api/auth'; // Importez votre service API

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(localStorage.getItem('token'));
  const [user, setUser] = useState(null); // Maintenu pour une future utilisation

  const login = async (email, password) => {
    // Utilisez directement la fonction importée
    const response = await apiLogin(email, password);
    
    localStorage.setItem('token', response.token);
    setToken(response.token);
    
    // Décodez le token si nécessaire pour obtenir les infos utilisateur
    // Exemple basique (à adapter selon votre JWT) :
    const userData = {
      email,
      role: response.role || 'user' // Valeur par défaut si non fournie
    };
    setUser(userData);
  };

  const logout = () => {
    localStorage.removeItem('token');
    setToken(null);
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ token, user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};