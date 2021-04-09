public class ComplexNumber {
    /* Real part of a complex number */
    public double re;
    /* Imaginary part of a complex number */
    public double im;

    public ComplexNumber(double re, double im){
        this.re = re;
        this.im = im;
    }

    public double gerRe(){
        return re;
    }

    public double getIm(){
        return im;
    }

    public double getSqrModule(){
        return re*re + im*im;
    }
    
    public ComplexNumber plus(ComplexNumber complexNumber){
        return new ComplexNumber(this.re + complexNumber.re, this.im+complexNumber.im);
    }
    
    public ComplexNumber mult(ComplexNumber complexNumber){
        return new ComplexNumber(this.re * complexNumber.re - this.im * complexNumber.im,
                                 this.im*complexNumber.re + this.re * complexNumber.im);
    }
}
