import React, { useState } from 'react';
import { TextField, Button, Select, MenuItem, FormControl, InputLabel, Box, Grid } from '@mui/material';

const CreateCharacterForm = () => {
  const [name, setName] = useState('');
  const [gender, setGender] = useState('');
  const [age, setAge] = useState('');
  const [hairColor, setHairColor] = useState('');
  const [eyeColor, setEyeColor] = useState('');
  const [skinColor, setSkinColor] = useState('');

  const handleCreateCharacter = () => {
    
  };

  return (
    <Box
    sx={{
      marginTop: 8,
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
    }}
  >
      <form onSubmit={handleCreateCharacter}>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField label="Name" value={name} onChange={event => setName(event.target.value)} />
          </Grid>
          <Grid item xs={12}>  
            <FormControl>
              <InputLabel>Gender</InputLabel>
              <Select value={gender} onChange={event => setGender(event.target.value)}>
                <MenuItem value="male">Male</MenuItem>
                <MenuItem value="female">Female</MenuItem>
              </Select>
            </FormControl>
          </Grid>
          <Grid item xs={12}>  
            <TextField type="number" label="Age" value={age} onChange={event => setAge(event.target.value)} />
          </Grid>
          <Grid item xs={12}>
            <TextField label="Hair color" value={hairColor} onChange={event => setHairColor(event.target.value)} />
          </Grid>
          <Grid item xs={12}>
            <TextField label="Eye color" value={eyeColor} onChange={event => setEyeColor(event.target.value)} />
          </Grid>
          <Grid item xs={12}>
            <FormControl>
              <InputLabel>Skin color</InputLabel>
              <Select value={skinColor} onChange={event => setSkinColor(event.target.value)}>
                <MenuItem value="ivory">Ivory</MenuItem>
                <MenuItem value="fair">Fair</MenuItem>
                <MenuItem value="light">Light</MenuItem>
                <MenuItem value="medium-light">Medium Light</MenuItem>
                <MenuItem value="medium">Medium</MenuItem>
                <MenuItem value="medium-dark">Medium Dark</MenuItem>
                <MenuItem value="dark">Dark</MenuItem>
                <MenuItem value="deep-dark">Deep Dark</MenuItem>
              </Select>
            </FormControl>
          </Grid>
          <Grid item xs={12}>  
            <Button type="submit">Create character</Button>
          </Grid>
        </Grid>    
      </form>
    </Box>
  );
};

export default CreateCharacterForm;