import axios from 'axios';

const API_URL = import.meta.env.VITE_API_URL;

export const login = async (email, password) => {
    const response = await fetch('/api/auth/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email, password })
    });
    
    if (!response.ok) {
      throw new Error('Échec de la connexion');
    }
    
    return response.json();
  };

export const changePassword = async (token, oldPassword, newPassword) => {
  return axios.post(`${API_URL}/api/auth/change-password`, 
    { oldPassword, newPassword },
    { headers: { Authorization: `Bearer ${token}` } }
  );
};