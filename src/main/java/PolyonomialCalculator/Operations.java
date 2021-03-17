package PolyonomialCalculator;

import java.util.*;
import static java.lang.Math.*;

public class Operations {
    private List<Monomial> checkMonomials(List<Monomial> monomialList){
        monomialList.removeIf(entry -> entry.getCoef() == 0);
        return monomialList;
    }

    public Polynomial addition(Polynomial input1, Polynomial input2){
        List<Monomial> output = new ArrayList<>();
        int outputRank = input1.getRank() - input2.getRank();
        for(Monomial entry1 : input1.getMonomials()){
            for(Monomial entry2 : input2.getMonomials()){
                if(entry1.getRank() == entry2.getRank()){
                    output.add(entry1.add(entry2));
                    entry1.setBrowsed(true);
                    entry2.setBrowsed(true);
                }
            }

            if(!entry1.isBrowsed()){
                output.add(entry1);
            }
        }

        for(Monomial entry : input2.getMonomials()){
            if(!entry.isBrowsed()){
                output.add(entry);
            }
        }

        return new Polynomial(this.checkMonomials(output), outputRank);
    }

    public Polynomial subtraction(Polynomial input1, Polynomial input2){
        List<Monomial> output = new ArrayList<>();

        for(Monomial entry1 : input1.getMonomials()){
            for(Monomial entry2 : input2.getMonomials()){
                if(entry1.getRank() == entry2.getRank()){
                    output.add(entry1.sub(entry2));
                    entry1.setBrowsed(true);
                    entry2.setBrowsed(true);
                }
            }

            if(!entry1.isBrowsed()){                                                // to make sure we haven't forgotten any elements from the first polynomial
                output.add(entry1);
            }
        }

        for(Monomial entry : input2.getMonomials()){                                    // to make sure we haven't forgotten any elements from the second polynomial
            if(!entry.isBrowsed()){
                output.add(new Monomial(-entry.getCoef(), entry.getRank()));
            }
        }

        return new Polynomial(this.checkMonomials(output), max(input1.getRank(), input2.getRank()));
    }

    public Polynomial multiplication(Polynomial input1, Polynomial input2){
        List<Monomial> output = new ArrayList<>();

        for(Monomial entry1 : input1.getMonomials()){
            for(Monomial entry2 : input2.getMonomials()){
                Monomial aux = entry1.mul(entry2);

                for(Monomial m : output){                       // checks whether there is a monomial in the current result with the same rank
                    if(aux.getRank() == m.getRank()){
                        m.setCoef(m.add(aux).getCoef());
                        aux.setBrowsed(true);
                        break;
                    }
                }

                if(!aux.isBrowsed()){                           // if there isn't, then it adds it to the result
                    output.add(aux);
                }
            }
        }

        return new Polynomial(output, input1.getRank() + input2.getRank());
    }

    public Polynomial division(Polynomial input1, Polynomial input2){
        List<Monomial> output = new ArrayList<>();

        Polynomial auxInput1 = new Polynomial(input1.getMonomials(), input1.getRank());
        Polynomial auxInput2 = new Polynomial(input2.getMonomials(), input2.getRank());

        while(auxInput1.getRank() >= auxInput2.getRank()){
            Monomial d = auxInput1.getMaxMonomial();
            Monomial i = auxInput2.getMaxMonomial();

            List<Monomial> c = new ArrayList<>();
            c.add(d.div(i));
            output.add(d.div(i));
            Polynomial aux = auxInput2.mul(new Polynomial(c, d.getRank() - i.getRank()));

            auxInput1 = auxInput1.sub(aux);
            auxInput1.setMonomials(this.checkMonomials(input1.getMonomials()));
        }

        return new Polynomial(output, input1.getRank() - input2.getRank());
    }

    public Polynomial derivative(Polynomial input){
        List<Monomial> output = new ArrayList<>();

        for(Monomial entry : input.getMonomials()){
            if(entry.getCoef() == 0){
                continue;
            }
            output.add(entry.deriv());
        }

        return new Polynomial(output, input.getRank()-1);
    }

    public Polynomial integration(Polynomial input){
        List<Monomial> output = new ArrayList<>();

        for(Monomial entry : input.getMonomials()){
            output.add(entry.integr());
        }

        return new Polynomial(output, input.getRank()+1);
    }
}
