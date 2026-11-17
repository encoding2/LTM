import { TestBed, ComponentFixture } from '@angular/core/testing';
import { DoctorSampleComponent } from 'src/app/mediconnect/components/doctorsample/doctorsample.component';
import { PatientSampleComponent } from 'src/app/mediconnect/components/patientsample/patientsample.component';

describe('DoctorSampleComponent', () => {

    let doctorFixture: ComponentFixture<DoctorSampleComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [DoctorSampleComponent]
        });

        doctorFixture = TestBed.createComponent(DoctorSampleComponent);
    });

    it('should create the doctor component', () => {
        const component = doctorFixture.componentInstance;

        expect(component).toBeTruthy();
    });

    it('should display doctor details with correct pipes', () => {
        doctorFixture.detectChanges();

        const compiled = doctorFixture.nativeElement;

        expect(compiled.textContent).toContain('Doctor ID: 1');
        expect(compiled.textContent).toContain('Full Name: DR. JANE SMITH');
        expect(compiled.textContent).toContain('Specialty: Cardiology');
        expect(compiled.textContent).toContain('Contact Number: 9876543210');
        expect(compiled.textContent).toContain('Email: jane@example.com');
        expect(compiled.textContent).toContain('Years of Experience: 15 years');
    });

    it('should contain Log Doctor Attributes button', () => {
        doctorFixture.detectChanges();

        const button =
            doctorFixture.nativeElement.querySelector('button');

        expect(button).toBeTruthy();
        expect(button.textContent)
            .toContain('Log Doctor Attributes');
    });
});


describe('PatientSampleComponent', () => {

    let patientFixture: ComponentFixture<PatientSampleComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [PatientSampleComponent]
        });

        patientFixture = TestBed.createComponent(PatientSampleComponent);
    });

    it('should create the patient component', () => {
        const component = patientFixture.componentInstance;

        expect(component).toBeTruthy();
    });

    it('should display patient details with correct pipes', () => {
        patientFixture.detectChanges();

        const compiled = patientFixture.nativeElement;

        expect(compiled.textContent).toContain('Patient ID: 1');
        expect(compiled.textContent).toContain('Full Name: John Doe');
        expect(compiled.textContent).toContain('Date of Birth: 01-01-1990');
        expect(compiled.textContent).toContain('Contact Number: 1234567890');
        expect(compiled.textContent).toContain('Email: john@example.com');
        expect(compiled.textContent)
            .toContain('Address: 123 Main Street, Cityville');
    });

    it('should contain Log Patient Attributes button', () => {
        patientFixture.detectChanges();

        const button =
            patientFixture.nativeElement.querySelector('button');

        expect(button).toBeTruthy();
        expect(button.textContent)
            .toContain('Log Patient Attributes');
    });
});