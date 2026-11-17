import { TestBed, ComponentFixture } from '@angular/core/testing';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { of } from 'rxjs';

import { DoctorSampleComponent } from
    'src/app/mediconnect/components/doctorsample/doctorsample.component';

describe('DoctorSampleComponent', () => {

    let doctorFixture: ComponentFixture<DoctorSampleComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [DoctorSampleComponent],
            providers: [
                {
                    provide: ActivatedRoute,
                    useValue: {
                        paramMap: of(convertToParamMap({ id: '25' }))
                    }
                }
            ]
        });

        doctorFixture =
            TestBed.createComponent(DoctorSampleComponent);
    });

    it('should read doctor ID from route parameter', () => {

        const component =
            doctorFixture.componentInstance;

        component.ngOnInit();

        expect(component.doctorId).toBe(25);
    });

    it('should display route doctor ID and doctor details', () => {

        doctorFixture.detectChanges();

        const compiled =
            doctorFixture.nativeElement;

        expect(compiled.textContent)
            .toContain('Route Doctor ID: 25');

        expect(compiled.textContent)
            .toContain('Doctor ID: 1');

        expect(compiled.textContent)
            .toContain('Full Name: DR. JANE SMITH');

        expect(compiled.textContent)
            .toContain('Specialty: Cardiology');
    });
});