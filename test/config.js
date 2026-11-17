const noOfDay = 32;

const testSuites = [
  {
  "day": 1,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayOneTest.java"
      ],
      "testcases": [
        {
          "name": "testDoctorConstructorAndGetters",
          "value": "Checks whether the Doctor parameterized constructor correctly initializes doctor details and getters return the assigned values."
        },
        {
          "name": "testDoctorSettersAndGetters",
          "value": "Checks whether Doctor setters correctly update doctor details and getters return the updated values."
        }
      ]
    }
  ]
},
{
  "day": 2,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayTwoTest.java"
      ],
      "testcases": [
        {
          "name": "testClinicConstructorAndGetters",
          "value": "Checks whether the Clinic parameterized constructor correctly initializes clinic details and getters return the assigned values."
        },
        {
          "name": "testClinicSettersAndGetters",
          "value": "Checks whether Clinic setters correctly update clinic details and getters return the updated values."
        },
        {
          "name": "testPatientConstructorAndGetters",
          "value": "Checks whether the Patient parameterized constructor correctly initializes patient details and getters return the assigned values."
        },
        {
          "name": "testPatientSettersAndGetters",
          "value": "Checks whether Patient setters correctly update patient details and getters return the updated values."
        }
      ]
    }
  ]
},
{
  "day": 3,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayThreeTest.java"
      ],
      "testcases": [
        {
          "name": "testDatabaseConnectionManagerHasGetConnectionMethod",
          "value": "Checks whether DatabaseConnectionManager contains the required getConnection method."
        },
        {
          "name": "testGetConnection",
          "value": "Checks whether the getConnection method successfully provides a database connection."
        }
      ]
    }
  ]
},
{
  "day": 4,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayFourTest.java"
      ],
      "testcases": [
        {
          "name": "testClinicServiceDelegatesGetAllClinicsToDAO",
          "value": "Checks whether ClinicService correctly delegates getAllClinics operation to the ClinicDAO."
        },
        {
          "name": "testDoctorServiceDelegatesGetDoctorByIdToDAO",
          "value": "Checks whether DoctorService correctly delegates getDoctorById operation to the DoctorDAO."
        },
        {
          "name": "testPatientServiceDelegatesGetPatientByIdToDAO",
          "value": "Checks whether PatientService correctly delegates getPatientById operation to the PatientDAO."
        },
        {
          "name": "testClinicServiceDelegatesAddClinicToDAO",
          "value": "Checks whether ClinicService correctly delegates addClinic operation to the ClinicDAO."
        }
      ]
    }
  ]
},
{
  "day": 5,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayFiveTest.java"
      ],
      "testcases": [
        {
          "name": "testDoctorComparableSortsByYearsOfExperience",
          "value": "Checks whether Doctor implements Comparable and sorts doctors based on years of experience."
        },
        {
          "name": "testDoctorServiceSortsByExperience",
          "value": "Checks whether DoctorService correctly returns doctors sorted by years of experience."
        },
        {
          "name": "testPatientComparableSortsByName",
          "value": "Checks whether Patient implements Comparable and sorts patients based on patient name."
        },
        {
          "name": "testPatientServiceSortsByName",
          "value": "Checks whether PatientService correctly returns patients sorted by name."
        }
      ]
    }
  ]
},
{
  "day": 6,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DaySixTest.java"
      ],
      "testcases": [
        {
          "name": "testGetAllDoctors",
          "value": "Checks whether the DoctorService retrieves all doctors by delegating the operation to the DAO."
        },
        {
          "name": "testAddDoctor",
          "value": "Checks whether the DoctorService correctly delegates adding a doctor to the DAO."
        },
        {
          "name": "testGetDoctorById",
          "value": "Checks whether the DoctorService correctly retrieves a doctor by ID through the DAO."
        },
        {
          "name": "testGetDoctorSortedByExperience",
          "value": "Checks whether the DoctorService correctly sorts doctors by years of experience."
        }
      ]
    }
  ]
},
{
  "day": 7,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DaySevenTest.java"
      ],
      "testcases": [
        {
          "name": "testGetAllClinics",
          "value": "Checks whether the ClinicService correctly retrieves all clinics through the DAO."
        },
        {
          "name": "testGetClinicById",
          "value": "Checks whether the ClinicService correctly retrieves a clinic by its ID through the DAO."
        },
        {
          "name": "testAddClinic",
          "value": "Checks whether the ClinicService correctly delegates adding a clinic to the DAO."
        },
        {
          "name": "testUpdateClinic",
          "value": "Checks whether the ClinicService correctly delegates updating a clinic to the DAO."
        }
      ]
    }
  ]
},
{
  "day": 8,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayEightTest.java"
      ],
      "testcases": [
        {
          "name": "testGetAllPatients",
          "value": "Checks whether the PatientService correctly retrieves all patients through the DAO."
        },
        {
          "name": "testAddPatient",
          "value": "Checks whether the PatientService correctly delegates adding a patient to the DAO."
        },
        {
          "name": "testGetPatientById",
          "value": "Checks whether the PatientService correctly retrieves a patient by ID through the DAO."
        },
        {
          "name": "testGetAllPatientSortedByName",
          "value": "Checks whether the PatientService correctly returns patients sorted by name."
        }
      ]
    }
  ]
},
{
  "day": 9,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayNineTest.java"
      ],
      "testcases": [
        {
          "name": "testMediConnectApplicationConfiguration",
          "value": "Checks whether the MediConnect Spring Boot application class is correctly configured with the @SpringBootApplication annotation."
        }
      ]
    }
  ]
},
{
  "day": 10,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayTenTest.java"
      ],
      "testcases": [
        {
          "name": "testControllerClassesAndMethods",
          "value": "Checks whether the required controller classes are configured as REST controllers and contain the required controller methods."
        }
      ]
    }
  ]
},
 {
  "day": 11,
  "dayWiseTestcase": [
    {
      "fileName": [
        "DayElevenTest.java"
      ],
      "testcases": [
        {
          "name": "testEntityAnnotation",
          "value": "Checks whether the required entity class is annotated with @Entity."
        },
        {
          "name": "testIdAnnotation",
          "value": "Checks whether the primary key field is annotated with @Id."
        },
        {
          "name": "testGeneratedValueAnnotation",
          "value": "Checks whether the primary key field is configured with the @GeneratedValue annotation."
        },
        {
          "name": "testIdentityGenerationStrategy",
          "value": "Checks whether the @GeneratedValue annotation uses GenerationType.IDENTITY for automatic primary key generation."
        }
      ]
    }
  ]
},
  {
    "day": 12,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DayTwelveTest.java"
        ],
        "testcases": [
           {
                        "name": "testAddPatientToArrayList_Day12",
                        "value": "test Add Patient To ArrayList_Day12"
                    },
                    {
                        "name": "testGetAllPatientsSortedByNameFromArrayList_Day12",
                        "value": "test Get All Patients Sorted By Name From ArrayList_Day12"
                    },
                    {
                        "name": "testGetAllPatient_Day12",
                        "value": "test Get All Patient_Day12"
                    }
        ]
      }
    ]
  },
  {
    "day": 13,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DayThirteenTest.java"
        ],
        "testcases": [
			{
			"name": "testGetAllPatient_Day13",
			"value": "test Get All Patient_Day13"
			},
			{
				"name": "testGetAllPatientsSortedByName_Day13",
				"value": "test Get All Patients Sorted By Name_Day13"
			},
			{
				"name": "testUpdatePatientController_Day13",
				"value": "test Update Patient Controller_Day13"
			},
			{
				"name": "testDeletePatientController_Day13",
				"value": "test Delete Patient Controller_Day13"
			}
        ]
      }
    ]
  },
  {
    "day": 14,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DayFourteenTest.java"
        ],
        "testcases": [
          {
			"name": "testAddDoctorController_Day14",
			"value": "test Add Doctor Controller_Day14"
		},
		{
			"name": "testUpdateDoctorController_Day14",
			"value": "test Update Doctor Controller_Day14"
		},
		{
			"name": "testDeleteDoctorController_Day14",
			"value": "test Delete Doctor Controller_Day14"
		},
		{
			"name": "testGetAllDoctor_Day14",
			"value": "test Get All Doctor_Day14"
		},
		{
			"name": "testGetDoctorById_Day14",
			"value": "test Get Doctor By Id_Day14"
		}
        ]
      }
    ]
  },
  {
    "day": 15,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DayFifteenTest.java"
        ],
        "testcases": [
			{
				"name": "testGetAllClinicsController_Day15",
				"value": "test Get All Clinics Controller_Day15"
			},
			{
				"name": "testGetAllClinicsByLocationController_Day15",
				"value": "test Get All Clinics By Location Controller_Day15"
			},
			{
				"name": "testUpdateClinic_Day15",
				"value": "test Update Clinic_Day15"
			},
			{
				"name": "testDeleteClinic_Day15",
				"value": "test Delete Clinic_Day15"
			}
        ]
      }
    ]
  },
  {
    "day": 16,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DaySixteenTest.java"
        ],
        "testcases": [
           {
			"name": "testAddPatientThrowsPatientAlreadyExistsException_Day16",
			"value": "test Add Patient Throws Patient Already Exists Exception_Day16"
			},
			{
				"name": "testGetPatientByIdThrowsPatientNotFoundException_Day16",
				"value": "test Get Patient By Id Throws Patient Not Found Exception_Day16"
			},
			{
				"name": "testAddDoctorThrowsDoctorAlreadyExistsException_Day16",
				"value": "test Add Doctor Throws Doctor Already Exists Exception_Day16"
			}
        ]
      }
    ]
  },
  {
    "day": 17,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DaySeventeenTest.java"
        ],
        "testcases": [
		{
			"name": "testServiceGetAllAppointments_Day17",
			"value": "test Service Get All Appointments_Day17"
		},
		{
			"name": "testServiceGetAppointmentById_Day17",
			"value": "test Service Get Appointment By Id_Day17"
		},
		{
			"name": "testControllerCreateAppointment_Day17",
			"value": "test Controller Create Appointment_Day17"
		},
		{
			"name": "testUpdateAppointment_Day17",
			"value": "test Update Appointment_Day17"
		}
        ]
      }
    ]
  },
  {
    "day": 18,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DayEighteenTest.java"
        ],
        "testcases": [
            {
				"name": "testCreateBilling_Day18",
				"value": "test Create Billing_Day18"
			},
			{
				"name": "testGetAllBills_Day18",
				"value": "test Get All Bills_Day18"
			},
			{
				"name": "testGetBillsByPatientId_Day18",
				"value": "test Get Bills By PatientId_Day18"
			},
			{
				"name": "testGetBillByIdService_Day18",
				"value": "test Get Bill By Id Service_Day18"
			},
			{
				"name": "testDeleteBillingService_Day18",
				"value": "test Delete Billing Service_Day18"
			}
        ]
      }
    ]
  },
  {
    "day": 19,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DayNineteenTest.java"
        ],
        "testcases": [
					{
                        "name": "testGenerateToken_Day19",
                        "value": "test Generate Token_Day19"
                    },
                    {
                        "name": "testValidateToken_Day19",
                        "value": "test Validate Token_Day19"
                    },
                    {
                        "name": "testGetPatient_Day19",
                        "value": "test Get Patient_Day19"
                    },
                    {
                        "name": "testUnauthorisedAddDoctor_Day19",
                        "value": "test Unauthorised Add Doctor_Day19"
                    },
                    {
                        "name": "testDoctorControllerAddDoctor_Day19",
                        "value": "test Doctor Controller Add Doctor_Day19"
                    },
                    {
                        "name": "testAddClinic_Day19",
                        "value": "test Add Clinic_Day19"
                    }
        ]
      }
    ]
  },
  {
    "day": 20,
    "dayWiseTestcase": [
      {
        "fileName": [
          "DayTwentyTest.java"
        ],
        "testcases": [
			{
				"name": "testRegisterUser_Failure_Day20",
				"value": "test Register User_Failure_Day20"
			},
			{
				"name": "testLoginUser_Success_Day20",
				"value": "test Login User_Success_Day20"
			},
			{
				"name": "testGetUserDetails_Success_Day20",
				"value": "test Get User Details_Success_Day20"
			},
			{
				"name": "testGetUserDetails_UserNotFound_Day20",
				"value": "test Get User Details_UserNotFound_Day20"
			}
        ]
      }
    ]
  },
{
  day: 21,
  dayWiseTestcase: [
    {
      fileName: [
        "day_21.test.js"
      ],
      testcases: [
			{      
			"name": "test login function should log correct information - Day 21",
			"value": "test login function should log correct information - Day 21"
			},
			{
			"name": "test register function should log correct information - Day 21",
			"value": "test register function should log correct information - Day 21"
			}			
        ]
    }
  ]
},
 {
    "day": 22,
    "dayWiseTestcase": [
      {
        "fileName": [
          "day_22.spec.ts"
        ],
        "testcases": [
          {
		"name": "Model Classes Test Suite should create a Patient object and log its attributes",
		"value": "Model Classes Test Suite should create a Patient object and log its attributes - Day22"
		},
		{
		"name": "Model Classes Test Suite should create a Doctor object and log its attributes",
		"value": "Model Classes Test Suite should create a Doctor object and log its attributes - Day22"
		},
		{
		"name": "Model Classes Test Suite should create a Clinic object and log its attributes",
		"value": "Model Classes Test Suite should create a Clinic object and log its attributes - Day22"
		},
		{
		"name": "Model Classes Test Suite should create an Appointment object and log its attributes",
		"value": "Model Classes Test Suite should create an Appointment object and log its attributes - Day22"
		}
        ]
      }
    ]
  },
  {
    "day": 23,
    "dayWiseTestcase": [
      {
        "fileName": [
          "day_23.spec.ts"
        ],
        "testcases": [
            {
			"name": "PatientSampleComponent should create the patient component",
			"value": "Patient Sample Component should create the patient component -- Day23"
			},
			{
				"name": "PatientSampleComponent should display patient details",
				"value": "Patient Sample Component should display patient details - Day23"
			},
			{
				"name": "DoctorSampleComponent should create the doctor component",
				"value": "Doctor Sample Component should create the doctor component - Day23"
			},
			{
				"name": "DoctorSampleComponent should display doctor details",
				"value": "Doctor Sample Component should display doctor details - Day23"
			}
        ]
      }
    ]
  },
  { 
  "day": 24, 
  "dayWiseTestcase": [ 
    { 
      "fileName": [ 
        "day_24.spec.ts" 
      ], 
      "testcases": [ 
        { 
          "name": "DoctorSampleComponent should create the doctor component", 
          "value": "Checks whether the DoctorSampleComponent is created successfully." 
        }, 
        { 
          "name": "DoctorSampleComponent should display doctor details", 
          "value": "Checks whether the doctor details such as doctor ID, name, specialization, and other attributes are displayed correctly in the template." 
        }, 
        { 
          "name": "DoctorSampleComponent should contain Log Doctor Attributes button", 
          "value": "Checks whether the DoctorSampleComponent contains a button for logging doctor attributes." 
        }, 
        { 
          "name": "PatientSampleComponent should create the patient component", 
          "value": "Checks whether the PatientSampleComponent is created successfully." 
        }, 
        { 
          "name": "PatientSampleComponent should display patient details", 
          "value": "Checks whether the patient details such as patient ID, name, email, and other attributes are displayed correctly in the template." 
        }, 
        { 
          "name": "PatientSampleComponent should contain Log Patient Attributes button", 
          "value": "Checks whether the PatientSampleComponent contains a button for logging patient attributes." 
        } 
      ] 
    } 
  ] 
},
{ 
  "day": 25, 
  "dayWiseTestcase": [ 
    { 
      "fileName": [ 
        "day_25.spec.ts" 
      ], 
      "testcases": [ 
        { 
          "name": "DoctorSampleComponent should create the doctor component", 
          "value": "Checks whether the DoctorSampleComponent is created successfully." 
        }, 
        { 
          "name": "DoctorSampleComponent should display doctor details with correct pipes", 
          "value": "Checks whether the DoctorSampleComponent displays doctor details using the required Angular pipes with the expected transformed values." 
        }, 
        { 
          "name": "DoctorSampleComponent should contain Log Doctor Attributes button", 
          "value": "Checks whether the DoctorSampleComponent contains a button for logging doctor attributes." 
        }, 
        { 
          "name": "PatientSampleComponent should create the patient component", 
          "value": "Checks whether the PatientSampleComponent is created successfully." 
        }, 
        { 
          "name": "PatientSampleComponent should display patient details with correct pipes", 
          "value": "Checks whether the PatientSampleComponent displays patient details using the required Angular pipes with the expected transformed values." 
        }, 
        { 
          "name": "PatientSampleComponent should contain Log Patient Attributes button", 
          "value": "Checks whether the PatientSampleComponent contains a button for logging patient attributes." 
        } 
      ] 
    } 
  ] 
},
{ 
  "day": 26, 
  "dayWiseTestcase": [ 
    { 
      "fileName": [ 
        "day_26.spec.ts" 
      ], 
      "testcases": [ 
        { 
          "name": "DoctorSampleComponent should read doctor ID from route parameter", 
          "value": "Checks whether the DoctorSampleComponent reads the doctor ID correctly from the Angular route parameter." 
        }, 
        { 
          "name": "DoctorSampleComponent should display route doctor ID and doctor details", 
          "value": "Checks whether the DoctorSampleComponent displays the doctor ID obtained from the route parameter and the corresponding doctor details." 
        } 
      ] 
    } 
  ] 
},
{ 
  "day": 27, 
  "dayWiseTestcase": [ 
    { 
      "fileName": [ 
        "day_27.spec.ts" 
      ], 
      "testcases": [ 
        { 
          "name": "Create Form Components should create reactive form with required Doctor fields and validators", 
          "value": "Checks whether the Doctor form is implemented as an Angular Reactive Form with the required form controls and appropriate validators." 
        }, 
        { 
          "name": "Create Form Components should validate Patient form using template-driven binding and submit valid data", 
          "value": "Checks whether the Patient form uses template-driven form binding, validates the required fields, and submits the form successfully when valid data is entered." 
        } 
      ] 
    } 
  ] 
},
{
  day: 28,
  dayWiseTestcase: [
    {
      fileName: [
        "day_28.spec.ts"
      ],
      testcases: [
       {
		"name": "Auth Components Test Suite LoginComponent should create the login component",
		"value": "Auth Components Test Suite Login Component should create the login component-Day28"
	},
	{
		"name": "Auth Components Test Suite LoginComponent should initialize login form with empty fields",
		"value": "Auth Components Test Suite Login Component should initialize login form with empty fields-Day28"
	},
	{
		"name": "Auth Components Test Suite LoginComponent should validate username and password as required",
		"value": "Auth Components Test Suite Login Component should validate username and password as required-Day28"
	},
	{
		"name": "Auth Components Test Suite LoginComponent should display an error message if form is invalid on submit",
		"value": "Auth Components Test Suite Login Component should display an error message if form is invalid on submit-Day28"
	},
	{
		"name": "Auth Components Test Suite LoginComponent should display a success message on valid form submission",
		"value": "Auth Components Test Suite Login Component should display a success message on valid form submission-Day28"
	},
	{
		"name": "Auth Components Test Suite RegistrationComponent should create the registration component",
		"value": "Auth Components Test Suite Registration Component should create the registration component-Day28"
	},
	{
		"name": "Auth Components Test Suite RegistrationComponent should initialize registration form with empty fields",
		"value": "Auth Components Test Suite Registration Component should initialize registration form with empty fields-Day28"
	},
	{
		"name": "Auth Components Test Suite RegistrationComponent should validate required fields for registration form",
		"value": "Auth Components Test Suite Registration Component should validate required fields for registration form-Day28"
	},
	{
		"name": "Auth Components Test Suite RegistrationComponent should display a success message on valid registration",
		"value": "Auth Components Test Suite Registration Component should display a success message on valid registration-Day28"
	},
	{
		"name": "Auth Components Test Suite RegistrationComponent should display an error message for invalid registration form",
		"value": "Auth Components Test Suite Registration Component should display an error message for invalid registration form-Day28"
	}
        ]
    }
  ]
},
{
    day: 29,
    dayWiseTestcase: [
      {
        fileName: [
          "day_29.spec.ts"
        ],
        testcases: [
					{
                        "name": "AuthService should be created",
                        "value": "Auth Service should be created-Day29"
                    },
                    {
                        "name": "AuthService login should make a POST request to login",
                        "value": "Auth Service login should make a POST request to login-Day29"
                    },
                    {
                        "name": "AuthService getToken should get the token from localStorage",
                        "value": "Auth Service get Token should get the token from localStorage-Day29"
                    },
                    {
                        "name": "AuthService createUser should make a POST request to create a user",
                        "value": "Auth Service create User should make a POST request to create a user-Day29"
                    },
                    {
                        "name": "LoginComponent should create the component",
                        "value": "Login Component should create the component-Day29"
                    },
                    {
                        "name": "LoginComponent ngOnInit should initialize the userForm with empty fields and validators",
                        "value": "Login Component ngOnInit should initialize the userForm with empty fields and validators-Day29"
                    },
                    {
                        "name": "LoginComponent onSubmit should not call authService.login if the form is invalid",
                        "value": "Login Component onSubmit should not call authService.login if the form is invalid-Day29"
                    },
                    {
                        "name": "LoginComponent onSubmit should call authService.login with the login data if the form is valid",
                        "value": "Login Component onSubmit should call authService.login with the login data if the form is valid-Day29"
                    },
                    {
                        "name": "RegistrationComponent should create the component",
                        "value": "Registration Component should create the component-Day29"
                    },
                    {
                        "name": "RegistrationComponent ngOnInit should initialize the registrationForm with empty fields and validators",
                        "value": "Registration Component ngOnInit should initialize the registrationForm with empty fields and validators-Day29"
                    }
        ]
      }
    ]
  },
{
    day: 30,
    dayWiseTestcase: [
      {
        fileName: [
          "day_30.spec.ts"
        ],
        testcases: [
			{
				"name": "DashboardComponent should create the component",
				"value": "Dashboard Component should create the component-Day30"
			},
			{
				"name": "DashboardComponent should fetch doctor details on initialization",
				"value": "Dashboard Component should fetch doctor details on initialization-Day30"
			},
			{
				"name": "DashboardComponent should fetch clinics and appointments for the selected doctor",
				"value": "Dashboard Component should fetch clinics and appointments for the selected doctor-Day30"
			},
			{
				"name": "DashboardComponent should handle error when fetching doctor details",
				"value": "Dashboard Component should handle error when fetching doctor details-Day30"
			},
			{
				"name": "ClinicCreateComponent should create the component",
				"value": "Clinic Create Component should create the component-Day30"
			},
			{
				"name": "ClinicCreateComponent should initialize the form",
				"value": "Clinic Create Component should initialize the form-Day30"
			},
			{
				"name": "ClinicCreateComponent should submit the form and call addClinic API",
				"value": "Clinic Create Component should submit the form and call addClinic API-Day30"
			},
			{
				"name": "ClinicCreateComponent should handle error when adding a clinic",
				"value": "Clinic Create Component should handle error when adding a clinic-Day30"
			}
        ]
      }
    ]
  },
{
    day: 31,
    dayWiseTestcase: [
      {
        fileName: [
          "day_31.spec.ts"
        ],
        testcases: [
					{
                        "name": "DashboardComponent should create the component",
                        "value": "Dashboard Component should create the component"
                    },
                    {
                        "name": "DashboardComponent should fetch patient details on initialization",
                        "value": "Dashboard Component should fetch patient details on initialization-Day31"
                    },
                    {
                        "name": "DashboardComponent should fetch clinics and appointments for a patient",
                        "value": "Dashboard Component should fetch clinics and appointments for a patient-Day31"
                    },
                    {
                        "name": "DashboardComponent should handle error when fetching patient details",
                        "value": "Dashboard Component should handle error when fetching patient details-Day31"
                    },
                    {
                        "name": "DashboardComponent should delete a patient",
                        "value": "Dashboard Component should delete a patient-Day31"
                    },
                    {
                        "name": "AppointmentCreateComponent should create the component",
                        "value": "Appointment Create Component should create the component-Day31"
                    },
                    {
                        "name": "AppointmentCreateComponent should initialize the form and fetch clinics and patient details on init",
                        "value": "Appointment Create Component should initialize the form and fetch clinics and patient details on init-Day31"
                    },
                    {
                        "name": "AppointmentCreateComponent should submit the form and call createAppointment API",
                        "value": "Appointment Create Component should submit the form and call create Appointment API-Day31"
                    }
        ]
      }
    ]
  },
{
    day: 32,
    dayWiseTestcase: [
      {
        fileName: [
          "day_32.spec.ts"
        ],
        testcases: [
           {
                        "name": "DoctorEditComponent should create the component",
                        "value": "Doctor Edit Component should create the component-Day32"
                    },
                    {
                        "name": "DoctorEditComponent should initialize the form and load doctor details",
                        "value": "Doctor Edit Component should initialize the form and load doctor details-Day32"
                    },
                    {
                        "name": "DoctorEditComponent should submit valid form and call updateDoctor API",
                        "value": "Doctor Edit Component should submit valid form and call updateDoctor API-Day32"
                    },
                    {
                        "name": "DoctorEditComponent should handle error when loading doctor details fails",
                        "value": "Doctor Edit Component should handle error when loading doctor details fails-Day32"
                    },
                    {
                        "name": "DashboardComponent should create the component",
                        "value": "Dashboard Component should create the component-Day32"
                    },
                    {
                        "name": "DashboardComponent should delete a doctor",
                        "value": "Dashboard Component should delete a doctor--Day32"
                    },
                    {
                        "name": "DashboardComponent should delete a clinic",
                        "value": "Dashboard Component should delete a clinic -Day32"
                    },
                    {
                        "name": "DashboardComponent should cancel an appointment",
                        "value": "Dashboard Component should cancel an appointment-Day32"
                    }
        ]
      }
    ]
  }
]
module.exports = {
  noOfDay,
  testSuites
};
