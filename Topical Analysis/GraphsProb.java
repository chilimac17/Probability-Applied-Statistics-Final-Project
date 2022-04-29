import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraphsProb {
    /**
     * Global Variables
     */
    File inputFile = new File("Salter.csv");
	private Scanner csvReader;
    private ArrayList<Double> xValList = new ArrayList<>(); 
    private ArrayList<Double> yValList = new ArrayList<>();
    /**
	 * This method is used to read the csv file created by plotter and save the x and y values in seperate arrayLists. First it creates a scanner to read the file.
	 * Then it stores every line and splits it up at the ",". Doing this will have the x and y values saved in position 0 and 1 in the temp array called row. Once the values are
	 * obtained then it will add them to the proper lists.
	 * @param xlist
	 * @param ylist
	 */
	public void csvToArrayList(ArrayList<Double> xlist,ArrayList<Double> ylist){
        String line = "";
        try{
            csvReader = new Scanner(inputFile);
            String headline = csvReader.nextLine();
            while(csvReader.hasNextLine()){		
                line = csvReader.nextLine();
                String[] row = line.split(",");
                String xVal = row[0];
                String yVal = row[1];
                xlist.add(Double.valueOf(xVal));
                ylist.add(Double.valueOf(yVal));
            }
        }catch(Exception e){
            System.out.println("ERROR1" + e.toString() + "THIS IS LINE: "+ line);
        }
    }
    /**
     * This method will add the values into the HashMap
     * @param map
     * @return HashMap
     */
	public HashMap<Integer,Integer> addValue(HashMap<Integer,Integer> map){
		for(int i = 0; i <= 100; i++){
			map.put(i, (int)Math.pow(i,2));
		}
		
		return map;
	}
    /**
     * This method was created to print out an array for testing purposes
     * @param list
     */
	public void printArrayList(ArrayList<Double> list){
        for(int i =0; i < list.size(); i++){
            if(i == list.size()-1){
                System.out.print(list.get(i));
            }else{
            System.out.print(list.get(i) + "\n");
            }
        }
    }
	/**
     * This method was created to print out a hashmap for testing purposes
     * @param list
     */
	public void printHashMap(HashMap<Integer,Integer> map){
		for(Integer i : map.keySet()){
			System.out.println("x = " + i + " y = " + map.get(i));
		}
	}
	
    /**
     * This method will take in 2 hash maps. It will take the original data from the first hash map salt it and put all the values in a new hash map
     * @param graphData
     * @param saltyData
     * @return HashMap 
     */
	public HashMap<Integer,Integer> saltData(HashMap<Integer,Integer> graphData,HashMap<Integer,Integer> saltyData){
		for(Integer i : graphData.keySet()) {
			int temp = graphData.get(i);
			temp = temp + (int)(-600 + Math.random() * 600);
			saltyData.put(i,temp);
		}
		return saltyData;
	}
	/**
     * This method takes in the salted data and it smoothes the data and stores it into a arraylist.
     * @param saltData
     * @param smoothHashMap
     * @return ArrayList
     */
    public ArrayList<Double> smoothDataAr(ArrayList<Double> saltData){
        ArrayList<Double> yVal = new ArrayList<>();
        DescriptiveStatistics stats = new DescriptiveStatistics();
		stats.setWindowSize(5);
		double temp;
        for(int i =0; i < saltData.size(); i++){
            stats.addValue(saltData.get(i));
            temp = (int)stats.getMean();
            yVal.add(temp);
        }
        return yVal;
    }
	/**
     * This method takes in the salted data and empty hash map. It smoothes the data and stores it into the empty hash map.
     * @param saltData
     * @param smoothHashMap
     * @return HashMap
     */
	public HashMap<Integer,Integer> smoothData(HashMap<Integer,Integer> saltData,HashMap<Integer,Integer> smoothHashMap){
		DescriptiveStatistics stats = new DescriptiveStatistics();
		stats.setWindowSize(3);
		int temp;
		//put value into stats
		for(Integer i : saltData.keySet()){
			stats.addValue(saltData.get(i));
			temp = (int)stats.getMean();
			smoothHashMap.put(i,temp);
		}
	
		return smoothHashMap;
	}
    /**
     * This method uses JFREEchart to create a graph out of a arraylist.
     * @param originalData
     * @param graphTitle
     * @param fileName
     * @throws IOException
     */
    public void printGraphAr(ArrayList<Double> saltData,String graphTitle,String fileName) throws IOException{
        DefaultCategoryDataset data1 = new DefaultCategoryDataset();
        for(int i =0; i < saltData.size(); i++){
            data1.addValue( saltData.get(i) , graphTitle , String.valueOf(i));  
        }
        JFreeChart createGraph = ChartFactory.createLineChart(graphTitle,"X","Y",data1,PlotOrientation.VERTICAL,true,true,false);
		int widthOfImage = 1800;    
	    int heightOfImage = 800;   
	    File xSquaredChart = new File(fileName + ".jpeg");
	    System.out.println("Graph has been made!");
	    ChartUtils.saveChartAsJPEG(xSquaredChart ,createGraph, widthOfImage ,heightOfImage);
    }
	/**
     * This method uses JFREEchart to create a graph out of a hash map.
     * @param originalData
     * @param graphTitle
     * @param fileName
     * @throws IOException
     */
	public void printGraph(HashMap<Integer,Integer> originalData,String graphTitle,String fileName) throws IOException{
		DefaultCategoryDataset data1 = new DefaultCategoryDataset();
		int counter = 0;
		int xValue = 0;
		for(Integer i : originalData.keySet()) {
			counter++;
			if(counter == 2) {
				xValue += counter;
				counter = 0;
			}
			data1.addValue( originalData.get(i) , graphTitle , String.valueOf(xValue));
		}
		
		 JFreeChart createGraph = ChartFactory.createLineChart(graphTitle,"X","Y",data1,PlotOrientation.VERTICAL,true,true,false);
		 	
	        int widthOfImage = 1800;    
	        int heightOfImage = 800;   
	        File xSquaredChart = new File(fileName + ".jpeg");
	        System.out.println("Graph has been made!");
	        ChartUtils.saveChartAsJPEG(xSquaredChart ,createGraph, widthOfImage ,heightOfImage);
	}
    /**
     * This method displays the results of the salted data before and after it has been smoothed out.
     */
    public void resultsAr(){
        ArrayList<Double> yVal = new ArrayList<>();
        csvToArrayList(xValList, yValList);
        try {
            printGraphAr(yValList, "Salted Data", "Salted Data");
        } catch (IOException e) {
            e.printStackTrace();
        }
        yVal = smoothDataAr(yValList);
        try {
            printGraphAr(yVal, "Smooth Data", "Smooth Data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
