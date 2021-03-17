package PolyonomialCalculator;// independent from the controller and view
// this is where the magic happens

import java.util.*;
import java.util.regex.*;

public class Model {
    Polynomial polynomial1;
    Polynomial polynomial2;

    public Model(){
        polynomial1 = new Polynomial();
        polynomial2 = new Polynomial();
    }

    public Model(String polynomial1, String polynomial2){
        this.polynomial1 = createPolynomial(polynomial1);
        this.polynomial2 = createPolynomial(polynomial2);
    }

    public String addition(){
        return polynomial1.add(polynomial2).toString();
    }

    public String subtraction(){
        return polynomial1.sub(polynomial2).toString();
    }

    public String multiplication(){
        return polynomial1.mul(polynomial2).toString();
    }

    public String division(){
        return polynomial1.div(polynomial2).toString();
    }

    public String derivative(){
        return polynomial1.deriv().toString();
    }

    public String integration(){
        return polynomial1.integ().toString();
    }

    private Polynomial createPolynomial(String pol){
        List<Monomial> monomialList = new ArrayList<>();

        Pattern pattern = Pattern.compile("[+-]?((\\d+(\\.\\d+)?)\\**)?x?(\\^\\d+)?", Pattern.CASE_INSENSITIVE);
        Matcher matcherPolynomial = pattern.matcher(pol);

        Pattern patternCoeficient = Pattern.compile("[+-]?(\\d+(\\.\\d+)?)?", Pattern.CASE_INSENSITIVE);
        Pattern patternRank = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);

        double coef = 0;
        int rank = 0;
        int maxRank = 0;

        String[] matches = matcherPolynomial.results().map(MatchResult::group).toArray(String[]::new);
        for (String entry : matches)
        {
            if(entry.equals("")){
                break;
            }
            Matcher matcherCoeficient = patternCoeficient.matcher(entry);
            String stringRank;

            if(matcherCoeficient.find()){
                try{
                    coef = Double.parseDouble(matcherCoeficient.group());
                }catch(NumberFormatException exception){
                    if(matcherCoeficient.group().equals("-")){
                        coef = -1;
                    }else{
                        coef = 1;
                    }
                }
            }

            stringRank = entry.substring(matcherCoeficient.end());
            Matcher matcherRank = patternRank.matcher(stringRank);
            if(matcherRank.find()){
                try {
                    rank = Integer.parseInt(matcherRank.group());
                }catch(NumberFormatException exception){
                    if(matcherRank.group().equals("x")){
                        rank = 1;
                    }
                }
            }else{
                rank = 0;
            }

            if(rank > maxRank){
                maxRank = rank;
            }

            monomialList.add(new Monomial(coef, rank));
        }
        return new Polynomial(monomialList, maxRank);
    }
}
