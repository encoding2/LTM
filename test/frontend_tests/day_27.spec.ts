import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { DoctorCreateComponent } from
    'src/app/mediconnect/components/doctorcreate/doctorcreate.component';

import { PatientCreateComponent } from
    'src/app/mediconnect/components/patientcreate/patientcreate.component';

describe('Create Form Components', () => {

    let doctorFixture: ComponentFixture<DoctorCreateComponent>;
    let patientFixture: ComponentFixture<PatientCreateComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [
                DoctorCreateComponent,
                PatientCreateComponent
            ],
            imports: [
                ReactiveFormsModule,
                FormsModule
            ]
        }).compileComponents();

        doctorFixture =
            TestBed.createComponent(DoctorCreateComponent);

        patientFixture =
            TestBed.createComponent(PatientCreateComponent);

        doctorFixture.detectChanges();
        patientFixture.detectChanges();
    });

    it('should create reactive form with required Doctor fields and validators', () => {

        const doctorComponent =
            doctorFixture.componentInstance;

        expect(doctorComponent).toBeTruthy();
        expect(doctorComponent.doctorForm).toBeTruthy();

        expect(doctorComponent.doctorForm.contains('doctorId'))
            .toBeTrue();

        expect(doctorComponent.doctorForm.contains('fullName'))
            .toBeTrue();

        expect(doctorComponent.doctorForm.contains('specialty'))
            .toBeTrue();

        expect(doctorComponent.doctorForm.contains('contactNumber'))
            .toBeTrue();

        expect(doctorComponent.doctorForm.contains('email'))
            .toBeTrue();

        expect(doctorComponent.doctorForm.contains('yearsOfExperience'))
            .toBeTrue();

        doctorComponent.doctorForm.patchValue({
            doctorId: 1,
            fullName: 'Dr. John Smith',
            specialty: 'Cardiology',
            contactNumber: '9876543210',
            email: 'john@example.com',
            yearsOfExperience: 10
        });

        expect(doctorComponent.doctorForm.valid)
            .toBeTrue();

        doctorComponent.doctorForm.patchValue({
            contactNumber: '123'
        });

        expect(doctorComponent.doctorForm.invalid)
            .toBeTrue();
    });

    it('should validate Patient form using template-driven binding and submit valid data', () => {

        const patientComponent =
            patientFixture.componentInstance;

        patientComponent.patient = {
            patientId: 1,
            fullName: 'John Doe',
            dateOfBirth: '1990-01-01',
            contactNumber: '9876543210',
            email: 'john@example.com',
            address: '123 Main Street'
        };

        expect(patientComponent.isFormValid())
            .toBeTrue();

        patientComponent.onSubmit();

        expect(patientComponent.successMessage)
            .toBe('Patient has been successfully created!');

        expect(patientComponent.errorMessage)
            .toBeNull();
    });

});