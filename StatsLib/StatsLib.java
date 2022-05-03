package StatsLib;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


public class StatsLib {

    
    /**
     * This method will get the mean of an array of ints 
     * first checks if the list is empty
     * then loops through the list and add all the values in the list 
     * after the loop it will divide by the size of the list and return the mean
     * @param list
     * @return double mean
    */
    public double getMean(int[] list){
        int answer = 0;
        if(list.length == 0){
            return 0;
        }
    
        for(int i = 0; i < list.length; i++){
            answer += list[i];
        }
        answer = answer / list.length;
        return answer;
    }
    /**
     * This method will get the mean of an array list of doubles
     * first checks if the list is empty
     * then loops through the list and add all the values in the list
     *  after the loop it will divide by the size of the list and return the mean
     * @param list
     * @return double mean
     */
    public double getMeanArrayList(ArrayList<Double> list){
        double answer = 0; 
        if(list.size() == 0){
            return 0;
        }
        for(int i = 0; i < list.size(); i++){
            answer += list.get(i);
        }
        answer = answer / list.size();
        return answer;
    }
    
    /**
     * This method will return the median of a list of ints
     * runs a check if the list is empty it will return 0
     * after it will check if the list is even or odd
     * if the list is even then it will take the two middle values add them then divide by 2
     * if the list is odd then it will return the middle value
     * @param list
     * @return double median of a list 
     */
    public double getMedian(int[] list){
        int result = 0;
        if(list.length == 0) return 0;
        if(list.length % 2 == 0){
            //list is even
            result = (list[list.length/2-1] + list[list.length/2])/2;
        }else{
            //list is odd
            result = list[(list.length)/2];
        }    
    
        return result;
    }
    /**
     * This method will return the mode of a list of ints
     * runs a check if the list is empty if it is return 0
     * then it will use a double for loop to check the values 
     * if a value occurs more than once a counter will be increased
     * also after it will run another check if count is greater than max counter
     * set that to max counter and save that element as the current mode
     * if a element happens to occur more than the max count
     * max count will be updated and so will the mode 
     * this method will return the mode after if goes through the list
     * @param list
     * @return double mode of a list
     */
    public double getMode(int[] list){
        int mode = 0; 
        int count;
        int maxCount = 0;
        
        if(list.length == 0) return 0;

        for(int i = 0; i < list.length; i++){
            count = 0;
            for(int j = 0; j < list.length; j++){
                int numCom = list[i];
                if(numCom == list[j]){
                    count++;
                }
                if(count > maxCount){
                    maxCount = count;
                    mode = numCom;
                } 
            }
        }
        return mode;
    }
    /*
        
    */
    /**
     * This method will take in a list of ints and return the standard deviation
     * it follows the standard deviation formaula
     *  -gets mean of a list
     *  -subtracts the mean from every value in the list
     *  -then it squares every value in the list
     *  -adds up the values in the list and divides by 1 less then the size of the list to get the variance
     *  -then takes the square root of that number to get the standard deviation 
     * Lastly it returns that value
     * @param list
     * @return double standard deviation
     */
    public double getStanD(int[] list){
        double stanD = 0;
        double mean = 0;
    
        for(int i =0; i < list.length; i++){
            mean = mean + list[i];
        }
        mean = mean / list.length;
        double tempVal = 0;
        for(int i = 0; i < list.length; i++){
            double tempValues = Math.pow(mean - list[i],2);
            tempVal = tempVal + tempValues;  
        }
    
        double variance = tempVal / (list.length -1);
        stanD = Math.sqrt(variance);
    
        return stanD;
    }

    /**
     * This method is almost a exact copy of the standard deviation formula 
     * except it does not take the squre root of the final answer and will return the variance 
     * steps as followed:
     * -gets mean of a list
     * -subtracts the mean from every value in the list
     * -then it squares every value in the list
     * -adds up the values in the list and divides by 1 less then the size of the list to get the variance
     * @param list
     * @return double variance
     */
    public double getVari(int[] list){
        double variance = 0;
        double mean = 0;
    
        for(int i =0; i < list.length; i++){
            mean = mean + list[i];
        }
        mean = mean / list.length;
        double tempVal = 0;
        for(int i = 0; i < list.length; i++){
            double tempValues = Math.pow(mean - list[i],2);
            tempVal = tempVal + tempValues;  
        }
    
        variance = tempVal / (list.length -1);

        return variance;
    }
    
    /**
     * This method is created to get the factorial of a number 
     * this method will assist in finding the combination and permutaion probability 
     * first i used a for loop to calcuate this which works perfectly fine
     * but i realized that you can use recursion to get the same result and write less code 
     * basically this method will call it self until it gets to the base case which is when num = 0 
     * @param num
     * @return double factorial 
     */
    public double factorial(double num){
		/*
        int factorialNum = 1;
		for(int i = (int)num; i >= 1; i--) {
			factorialNum = factorialNum * i;
			
		}
        */
        if(num == 0){
            return 1;
        }
		return num *factorial(num-1);
    }
    
    /**
     *  This method will use the factoral method above to find the combination probability
     *  it follows the formula: (n!) / (r)!*(n-r)!
     * @param n
     * @param r
     * @return double combination probability
     */
	public double findCombinationProb(double n,double r){
		double answer = 0;
		answer = factorial(n) / (factorial(r) * factorial(n-r));
		return answer;
	}
    
    /**
     * This method will use the factoral method above to find the permutation probability
     * it follows the formula: (n!) / (n-r)!
     * @param n
     * @param r
     * @return double permutation probability
     */
	public double findPermutationProb(double n, double r){
		double answer = 0;
		answer = factorial(n) /factorial(n - r);
		return answer;
	}
   
    /**
     *  ** for this method i used arraylists of strings with days of the week **  
     *  This method will take in two arrays lists of strings and return the union of both lists
     *  first i create a new array list that will return in the end
     *  then i loop through the first list adding every value in the new list
     *  next i loop throug the second list and i check with an if statement
     *  if the new list does not contain the value at position i then add it to the new list 
     *  after the second loop is finished i return the new list
     * @param dayOfWeekList
     * @param dayOfWeekList2
     * @return ArrayList<String> union of two array lists
     */
    public ArrayList<String> getUnion(ArrayList<String> dayOfWeekList,ArrayList<String> dayOfWeekList2){
        ArrayList<String> unionList = new ArrayList<>();
            for(int i = 0; i < dayOfWeekList.size(); i++){
                String days = dayOfWeekList.get(i);
                unionList.add(days);
            }
            for(int i = 0; i < dayOfWeekList2.size(); i++){
                String days2 = dayOfWeekList2.get(i);
                if(!unionList.contains(days2)){
                    unionList.add(days2);
                }
            }
        return unionList;
    }
    
    /**
     * This method will take in two arraylists and return the intersection of two arraylist
     * first i created a new arraylist to return and created a for loop that loops through the 
     *  first list. As its going through the first list it will run a if statement to check if 
     *  list 2 contains the element at position i. if it is true then it will add it to the new list
     *  once the loop is broken it will return the new list
     * @param list1
     * @param list2
     * @return ArrayList<String> intersection of two lists
     */
    public ArrayList<String> getIntersection(ArrayList<String> list1,ArrayList<String> list2){
        ArrayList<String> intersectionList = new ArrayList<>();
        
        for(int i = 0; i < list1.size(); i++){
            String days = list1.get(i);
            if(list2.contains(days)){
                intersectionList.add(days);
            }

        }
        return intersectionList;
    }
    
    /**
     * This method will take in one array list and return the compliment of it
     * to make this work with my days of the week examples i created a array that has 
     * all of the days of the week in it. Also I created a new arraylist to return at the end.
     * I run through a loop through the premade list then i run a check if the list that was input does not
     * contain the current element in the premade list add it to the new list at the end of the loop
     * i return the new list  
     * @param list
     * @return ArrayList<String> compliment of list
     */
    public ArrayList<String> getCompliment(ArrayList<String> list){
        ArrayList<String> complimentList = new ArrayList<>();
        String[] daysOfTheWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        for(int i = 0; i < daysOfTheWeek.length; i++){
            if(!list.contains(daysOfTheWeek[i])){
                complimentList.add(daysOfTheWeek[i]);
            }
        }

        return complimentList;
    }
    /**
     * This method takes in the probability of your favorable event as p and takes the compliment of
     * that probability as q. The number of trials as n and number of times for a specific outcomes from
     * n trials. 
     * @param p
     * @param q
     * @param n
     * @param y
     * @return double binomial distribution 
     */
    public double getBinomialDistribution(double p, double q, int n, int y){
        double binomialDistribution = 0;
        double comb = findCombinationProb(n, y);
        p = Math.pow(p, y);
        q = Math.pow(q, n-y);
        binomialDistribution = comb * p * q;
         return binomialDistribution;
    }
    /**
     * This method takes in the probability of your favorable event as p.
     * The number of trials as n and number of times for a specific outcomes from
     * n trials. 
     * @param p
     * @param n
     * @param y
     * @return double binomial distribution 
     */
    public double getBinomialDistribution2(double p,int n, int y){
        double binomialDistribution = 0;
        double q = (1-p);
        double comb = findCombinationProb(n, y);
        p = Math.pow(p, y);
        q = Math.pow(q, n-y);
        binomialDistribution = comb * p * q;
         return binomialDistribution;
    }
     
    /**
     * extra credit handles <=,>=:
     * This method takes in the probability of your favorable event as p.
     * The number of trials as n and number of times for a specific outcomes from
     * n trials. 
     * @param p
     * @param q
     * @param n
     * @param y
     * @param eq
     * @return double binomial distribution
     */
    public double getBinomialDistributionEC(double p, double q, double n, double y,String eq){
        double binomialDistribution = 0;
        char greatOrLess = eq.charAt(0);
        if(greatOrLess == '<'){
            for(int i = 0; i <= y; i++){
                binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
              }
        }
        if(greatOrLess == '>'){
            for(int i = (int)y; i <= n; i++){
                binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
            }
        }

        /*
        switch(eq){
            case "<=":
                for(int i = 0; i <= y; i++){
                  binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
                }
                break;
                
            case ">=":
                for(int i = (int)y; i <= n; i++){
                    binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
                }
                break;
            default:
                System.out.println("Please enter either <= or >= as the last parameter");

        }
        */
        return binomialDistribution;
    }
    /**
     * Extra Credit Handles <=,>=
     * This method takes in the probability of your favorable event as p.
     * The number of trials as n and number of times for a specific outcomes from
     * n trials. It also takes in a string that can either be <= or >= to show ------
     * 
     * @param p
     * @param q
     * @param n
     * @param y
     * @param eq
     * @return double binomial distribution
     */
    public double getBinomialDistributionEC2(double p,double n, double y,String eq){
        double binomialDistribution = 0;
        double q = (1-p);
        char greatOrLess = eq.charAt(0);
        if(greatOrLess == '<'){
            for(int i = 0; i <= y; i++){
                binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
              }
        }
        if(greatOrLess == '>'){
            for(int i = (int)y; i <= n; i++){
                binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
            }
        }else{
            System.out.println("Please enter either <= or >= as the last parameter");
        }

        /*
        switch(eq){
            case "<=":
                for(int i = 0; i <= y; i++){
                  binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
                }
                break;
                
            case ">=":
                for(int i = (int)y; i <= n; i++){
                    binomialDistribution  += getBinomialDistribution(p, q,(int)n, i);
                }
                break;
            default:
                System.out.println("Please enter either <= or >= as the last parameter");

        }
        */
        return binomialDistribution;
    }
    /**
     * This method takes in as input the probability of an event occuring as p
     * the compliment of that event occuring as q and how every many trials until success as y
     * @param q
     * @param p
     * @param y
     * @return double Geometric Distribution
     */
    public double getGeometricDistribution(double q, double p,int y){
        double geoDistribution = 0;
        q = Math.pow(q,y-1);
        geoDistribution = q * p;
        return geoDistribution;
    }
    /**
     * This method will show hypergeometric distribution which takes in the combination probability
     * of N and n as the total probabilty, r and y as the the first combination probability which we will call 
     * comb1, and N-r, n-y as the second combination probability calling it comb2. Then it will multiply
     * comb1 and comb 2 and divide by the total probability. 
     * @param r
     * @param y
     * @param n
     * @param N
     * @return double Hyper Geometric Distribution
     */
    public double getHyperGeometricDistribution(double r, double y,double n, double N){
        double hyperGeoDIstribution = 0;
        double comb1 = findCombinationProb(r, y);
        double comb2 = findCombinationProb(N-r, n-y);
        double totalComb = findCombinationProb(N, n);
        hyperGeoDIstribution = (comb1 * comb2) / totalComb;
        return hyperGeoDIstribution;
    }
    /**
     * In this method we will take in lambada and y which is the max value you are testing for your pmf
     * For example: if y = 4 then this method will compute y=0,y=1,y=2,y=3,y=4.
     * @param lam
     * @param y
     * @return double poisson distribution
     */
    public double getPoissonDistribution(double lam,double y){
        double poissonDistribution =0;
        double e = 2.7182818;
        for(int i =0; i < y; i++){
            double top = Math.pow(lam, i);
            double bottom = factorial(i);
            double multE = Math.pow(e, lam);
            double answer = (top/bottom) * multE;
            poissonDistribution += answer;
        }
        return poissonDistribution;
    }
    /**
     * This method takes in the standard deviation, the mean, and the upper and lower bounds
     * first the method will verify the the within number with the upper and lower bounds 
     * after it uses the within number to find the k value. Once k value is found it will use
     * the formula 1 - (1/k^2) to get the answer. If the within number is not verified then the method will
     * return 0.
     * @return double chebyshev
     */
    public double getChebyshev(double std, double mean, double lowerBound, double upperBound){
        double chebyshev = 0;
        double within;
        double upper = upperBound - mean;
        double lower = mean -lowerBound;
        if(upper == lower){
            within = upper;
            double k = within / std;
            chebyshev = 1 - (1/Math.pow(k, 2));
        }
        return chebyshev;
    }
    /**
     * This method will get the factorial of a int and return it as a big integer
     * @param n
     * @return BigInteger factrorial
     */
    public BigInteger factorialOfBigInts(int n){
        BigInteger bi = new BigInteger("1");
        long newVal = (long)n;
        BigInteger val = BigInteger.valueOf(newVal);
        if(n == 0){
            return bi;
        }
        return val.multiply(factorialOfBigInts(n-1));
    }
    /**
     * This method takes in a A value and B value to get the uniform distribution
     * @param a
     * @param b
     * @return Double Uniform Distribution
     */
    public double getUniformDistribution(double a, double b){
        double ud = 0;
        ud = 1/(b-a);
        return ud;
    }
    /**
     * This method calculates the probability of uniform distribution an interdral with the variables a,b,c,d.
     * @param a
     * @param b
     * @param c
     * @param d
     * @return Calculating Probabilty 
     */
    public double getCalcProbabilityUN(double a, double b, double c, double d){
        double calcProb = 0;
        calcProb = (d-c)/(b-a);
        return calcProb;
    }
    /**
     * This method calculates the expected of the uniform distribution
     * @param a
     * @param b
     * @return Double Expected
     */
    public double expectedUN(double a,double b){
        double ex = 0;
        ex = (b-a)/2;
        return ex;
    }
    /**
     * This is a method that calculates the variance of the uniform distribution
     * @param a
     * @param b
     * @return Double Variance 
     */
    public double variance(double a,double b){
        double variance = 0;
        variance = Math.pow((b-a), 2)/12;
        return variance;
    }
    //TRY INTERGRAL AND DOUBLE 
    /**
     * This method is used to populate an array list.
     * it will be used for testing the union, intersection, and compliment methods above
     * @param test
     * @return ArrayList<String> a list populated with strings of days of the week
     */
    public ArrayList<String> popTest1(ArrayList<String> test){
        String[] daysWeekL = {"Monday","Wednesday","Thursday","Sunday"};
        for(int i = 0; i < daysWeekL.length; i++){
            test.add(daysWeekL[i]);
        }
        return test;
    }
    /**
     * This method is used to populate an array list.
     * it will be used for testing the union, intersection, and compliment methods above
     * @param test
     * @return ArrayList<String> a list populated with strings of days of the week
     */
    public ArrayList<String> popTest2(ArrayList<String> test){
        String[] daysWeekL = {"Monday","Tuesday","Thursday","Friday","Saturday"};
        for(int i = 0; i < daysWeekL.length; i++){
            test.add(daysWeekL[i]);
        }
        return test;
    }
    /**
     * This method is used to populate an array list.
     * it will be used for testing the union, intersection, and compliment methods above.
     * @param test
     * @return ArrayList<String> a list populated with strings of days of the week
     */
    public ArrayList<String> popTest3(ArrayList<String> test){
        String[] daysWeekL = {"Tuesday","Friday"};
        for(int i = 0; i < daysWeekL.length; i++){
            test.add(daysWeekL[i]);
        }
        return test;
    }
    /**
     * This method was created to print out an array for testing purposes.
     * @param list
     */
    public void printArray(int[] list){
        for(int i =0; i < list.length; i++){
            if(i == list.length-1){
                System.out.print(list[i]);
            }else{
            System.out.print(list[i] + ",");
            }
        }
    }
    /**
     * This method was created to print out an arraylists for testing purposes.
     * @param list
     */
    public void printArrayList(ArrayList<String> list){
        for(int i =0; i < list.size(); i++){
            if(i == list.size()-1){
                System.out.print(list.get(i));
            }else{
            System.out.print(list.get(i) + ",");
            }
        }
    }
   
    /**
     * This method tests the methods created above.
     */
    public void results(){
        int[] testList = {2,5,5,7,17,17,17,23,56,87,99};
        ArrayList<String> test1 = new ArrayList<>();
        ArrayList<String> test2 = new ArrayList<>();
        ArrayList<String> test3 = new ArrayList<>();

        
        System.out.println("\nList: "+ Arrays.toString(testList));
        System.out.println("The mean of the list above is " + getMean(testList));
        System.out.println("The median of the list above is " + getMedian(testList));
        System.out.println("The mode of the list above is " + getMode(testList));
        System.out.println("The standard deviation of the list above is " + getStanD(testList));
        System.out.println("The varience of the list above is " + getVari(testList));

        System.out.println("The combination probability of 10 and 2 is " + findCombinationProb(10, 2));
        System.out.println("The permutation probability of 12 and 9 is " + findPermutationProb(12, 9));

        //populating array list to test union,intersection,compliment
        System.out.println("List 1: " + popTest1(test1));
        System.out.println("List 2: " + popTest2(test2));
        System.out.println("List 3: " + popTest3(test3));
        System.out.println("The union of the list 1 and list 2 is " + getUnion(test1, test2));
        System.out.println("The intersection of the list 1 and list 2 is " + getIntersection(test1, test2));
        System.out.println("The compliment of the list 3 is " + getCompliment(test3));
        //ec = extra credit, extra methods created to handle other cases
        System.out.println("Binomial Dis: " + getBinomialDistribution(0.2, 0.8, 3, 2));
        System.out.println("Binomial Dis2: " + getBinomialDistribution2(0.2, 3, 2));
        System.out.println("Binomial DisEC: " + getBinomialDistributionEC(0.2, 0.8, 3, 2, "<="));
        System.out.println("Binomial DisEC2: " + getBinomialDistributionEC2(0.2, 3, 2, ">="));
        System.out.println("Geo Dis: " + getGeometricDistribution(0.8, 0.2, 3));
        System.out.println("HyperGeo Dis: " + getHyperGeometricDistribution(6, 4, 5, 20));
        System.out.println("Poisson Dis: " + getPoissonDistribution(5, 3));
        System.out.println("Chebyshev Dis: " + getChebyshev(5, 75, 50, 100));
        System.out.println("Big Integer: " + factorialOfBigInts(10));
        System.out.println("Uniform dis");
        System.out.println("Calc Prob");
        System.out.println("Uniform dis expected");
        System.out.println("Uniform dis variance");

    }
}
