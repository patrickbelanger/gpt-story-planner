import React, { useState } from 'react';
import { TextField, Button, Select, MenuItem, FormControl, InputLabel, Box, Grid, FormHelperText } from '@mui/material';
import { useFormik } from 'formik';
import * as yup from 'yup';

const CreateCharacterForm = () => {
 
  const validationSchema = yup.object({
    firstName: yup
      .string()
      .required('Character first name is required'),
    lastName: yup
      .string(),
    gender: yup
      .string()
      .required("Character gender must be specified"),  
  });

  const formik = useFormik({
    initialValues: {
      firstName: '',
      lastName: '',
      gender: '',
    },
    validationSchema: validationSchema,
    onSubmit: (values) => {
      alert(JSON.stringify(values, null, 2));
    },
  });

  return (
    <Box
      sx={{
        marginTop: 8,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      }}>
      <form onSubmit={formik.handleSubmit}>
        <Grid container spacing={2}>
        <Grid item xs={12}>
            <TextField 
              label="First name" 
              name="firstName"
              value={formik.values.firstName} 
              onChange={formik.handleChange('firstName')}
              error={formik.touched.firstName && Boolean(formik.errors.firstName)}
              helperText={formik.touched.firstName && formik.errors.firstName} 
            />
          </Grid>
          <Grid item xs={12}>
            <TextField 
              label="Last name"
              value={formik.values.lastName} 
              onChange={formik.handleChange('lastName')}
              error={formik.touched.lastName && Boolean(formik.errors.lastName)}
              helperText={formik.touched.lastName && formik.errors.lastName} 
            />
          </Grid>
          <Grid item xs={12}>  
            <FormControl>
              <InputLabel>Gender</InputLabel>
              <Select
                name="gender"
                onChange={formik.handleChange}
                sx={{ width: '223px' }}
                error={formik.touched.gender && Boolean(formik.errors.gender)}>
                <MenuItem value="male">Male</MenuItem>
                <MenuItem value="female">Female</MenuItem>
                <MenuItem value="other">Other (specify)</MenuItem>
              </Select>
            </FormControl>
          </Grid>
          {/*
          <Grid item xs={12}>  
            <TextField 
              type="number" 
              label="Age" 
              value={age} 
              onChange={event => setAge(event.target.value)} 
            />
          </Grid>
          <Grid item xs={12}>
            <TextField 
              label="Hair color" 
              value={hairColor} 
              onChange={event => setHairColor(event.target.value)} 
            />
          </Grid>
          <Grid item xs={12}>
            <TextField 
              label="Eye color" 
              value={eyeColor} 
              onChange={event => setEyeColor(event.target.value)} 
            />
          </Grid>
          <Grid item xs={12}>
            <FormControl>
              <InputLabel>Skin color</InputLabel>
              <Select 
                value={skinColor} 
                onChange={event => setSkinColor(event.target.value)} 
                sx={{ width: '223px' }}>
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
          */}
          <Grid item xs={12}>  
            <Button type="submit">Create character</Button>
          </Grid>
        </Grid>    
      </form>
    </Box>
  );
};

export default CreateCharacterForm;