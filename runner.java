import java.util.ArrayList;
class vertex extends runner{
public ArrayList<String> edge;
    public ArrayList<Integer> weight;
    public vertex() {
    this.edge = new ArrayList<String>();
    this.weight = new ArrayList<Integer>();
}
}
public class runner{
static ArrayList<vertex> vertarr = new ArrayList<vertex>();
    static ArrayList<String> namevertexs = new ArrayList<String>();
static int i=0;
static vertex sour;
static vertex des;
static String wait = "";
static String holdvert = "";
public static boolean addedge (String source, String dest, int weight){
if(namevertexs.contains(source) && namevertexs.contains(dest)){
sour=vertarr.get(namevertexs.indexOf(source));
des=vertarr.get(namevertexs.indexOf(dest));
sour.edge.add(dest);
sour.weight.add(weight);
return true;
}
else{
   return false;
}
}
public static boolean removeEdges(String source, String destination){
if(namevertexs.contains(source) && namevertexs.contains(destination)){
sour=vertarr.get(namevertexs.indexOf(source));
des=vertarr.get(namevertexs.indexOf(destination));
    while(sour.edge.contains(destination)){
        sour.weight.remove(sour.edge.indexOf(destination));
        sour.edge.remove(destination);
    }
    return true;
}
else{
    return false;
}
}
public static void addVertex(String name){
if(!namevertexs.contains(name)){
namevertexs.add(name);
wait = name;
    vertex wait = new vertex();
    vertarr.add(wait);
}
}
public static boolean removeVertex(String name){
if(!namevertexs.contains(name)){
    return false;
}
sour=vertarr.get(namevertexs.indexOf(name));
namevertexs.remove(name);
while(i < namevertexs.size()){
    des = vertarr.get(i);
    if(des.edge.contains(name)){
        des.weight.remove(des.edge.indexOf(name));
        des.edge.remove(name);
        i++;
    }
    else{
        i++;
    }
}
vertarr.remove(sour);
return true;
}
public static boolean containsvertex(String name){
if(namevertexs.contains(name)){
    return true;
}
else{
    return false;
}
}
public static boolean Containsedge(String source, String dest){
if(namevertexs.contains(source) && namevertexs.contains(dest)){
sour=vertarr.get(namevertexs.indexOf(source));
    if(sour.edge.contains(dest)){
        return true;
    }
    else{
        return false;
    }
}
else{
    return false;
}
}
public static ArrayList<String> graph(ArrayList<String> vertexdec, ArrayList<String> vertexs, ArrayList<String> edges, ArrayList<Integer> weights){
 int j = 0;
 int i =0;
   while (i!=1){
       if(vertexdec.size()==0){
           i++;
       }
       else{
           addVertex(vertexdec.get(j));
           vertexdec.remove(j);
           j++;
       }
   }
   i = 0;
   j = 0;
   while (i!=1){
       if(vertexs.get(j)==null){
           i++;
       }
       else{
           addVertex(vertexs.get(j));
           j++;
       }
   }
   i = 0;
   j = 0;
   while (i!=1){
       if(edges.get(j)==null){
           i++;
       }
       else{
           addedge(vertexs.get(j), edges.get(j), weights.get(j));
           j++;
       }
   }
   return namevertexs;
}
}