import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
//we need this imports


public class App {
    public static void main(String[] args) throws Exception {


        JSONArray mahbub = new JSONArray(); //create json array ["hi","hello"]
        mahbub.put("Value1");
        mahbub.put("Value2");

        System.out.println(mahbub.toString()); //["Value1","Value2"]

        //get position 1 string
        System.out.println(mahbub.getString(0)); //value1



        JSONArray tanmay = new JSONArray(); //create json array ["hi","hello"]
        tanmay.put("Value3");
        tanmay.put("Value4");

        System.out.println(tanmay.toString()); //["Value3","Value4"]
        



     

        JSONArray multi_array = new JSONArray(); //create json array ["hi","hello"]
        multi_array.put(mahbub);
        multi_array.put(tanmay);

        System.out.println(multi_array.toString()); //[["Value1","Value2"],["Value3","Value4"]]
        //get position 1 array from multiarray
        System.out.println(multi_array.getJSONArray(0)); //["Value1","Value2"]

        //get a string from a multi_array
         System.out.println(multi_array.getJSONArray(0).getString(0)); //["Value1","Value2"]





        //convert string to json array
        String str = "[\"Value5\", \"Value6\"]";
        
        JSONArray from_string = new JSONArray(str);

        System.out.println(from_string.toString()); //["Value5","Value6"]





       //json to string
       String from_json = mahbub.toString();//["Value1","Value2"]
       String from_multi = multi_array.toString(); //[["Value1","Value2"],["Value3","Value4"]]

        System.out.println(from_json);// ["Value1","Value2"]
        System.out.println(from_multi); //[["Value1","Value2"],["Value3","Value4"]]












        // json array to list array
        List<String> normal2list = new ArrayList<>(); //this will be simple list like [Value1, Value2]
        //here we will use mahbub jsonArray

        for(int i = 0; i<mahbub.length(); i++){
            normal2list.add(mahbub.getString(i));
        }
        System.out.println(normal2list.toString());








        // list array to json array
        JSONArray from_list_array = new JSONArray(normal2list);

        System.out.println(from_list_array.toString()); //["Value1","Value2"]


        
        









        //multi_array to multi list
        List<List<String>> multi2list = new ArrayList<>(); //this will be multi list like [[Value1, Value2],[Value3, Value4]]. so it will be the lists of list
       
        //here we will use mahbub jsonArray

        //here remember this multi_array.getJSONArray(0)  is the first array from multi_array  and  multi_array.getJSONArray(0).getString(0) is the first string from the first array of multi_array 
        for(int i = 0; i<multi_array.length(); i++){

          List<String> templist = new ArrayList<>(); // we will use it to store every single arrays string here then we will use all temlist to make the multilist so multilist = some templist
          for(int j = 0; j<multi_array.getJSONArray(i).length(); j++){
            templist.add(multi_array.getJSONArray(i).getString(j));

          }
          multi2list.add(templist); 
          

        }
        System.out.println(multi2list.toString()); //[[Value1, Value2], [Value3, Value4]]

        
        
       
    






        //multi list to multi array
        JSONArray from_multi_list = new JSONArray();

        for (List<String> i : multi2list) {
            from_multi_list.put(new JSONArray(i));
        }

        System.out.println(from_multi_list.toString()); //[["Value1","Value2"],["Value3","Value4"]]
















        //the json which has key is called json object
        JSONObject json_obj = new JSONObject();

        json_obj.put("id 1", "value1");
        json_obj.put("id 1", "value2"); //if key is same, it will be added inside the key
        json_obj.put("id 2", "value3");//if key is not same, it will craete new key
        json_obj.put("id 2", "value4");

        System.out.println(json_obj); //{"id 2":"value4","id 1":"value2"}








        //string to list. but we should use JSOnArray as middleman but we also can do this
        String test = "[Value1, Value2],[Value1, Value2]";
        List<String> list1 = new ArrayList<>();
        list1.add(test);
        System.out.println(list1);


    


    }
    }
