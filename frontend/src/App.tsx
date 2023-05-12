import React from 'react';
import './App.css';
import CreateCharacterForm from './components/forms/create-character/CreateCharacterForm';
import Container from '@mui/material/Container';

function App() {
  return (
    <Container component="main" maxWidth="lg">
      <CreateCharacterForm />
    </Container>
  );
}

export default App;
