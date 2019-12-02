import java.util.*;
import java.io.*;
public class driver{  
public static void main(String args[]) {
vertex source;
vertex sec;
    ArrayList<String> changer = new ArrayList<String>();
    ArrayList<String> vertexdec = new ArrayList<String>();
    ArrayList<String> edgearray = new ArrayList<String>();
    ArrayList<String> vertexarray = new ArrayList<String>();
    ArrayList<Integer> weight = new ArrayList<Integer>();
    FileReader fr;
    fr = new FileReader(args[0]);
    BufferedReader buffread = new BufferedReader(fr);
    int buffcrawl;
    String plug="y";        
    for(buffcrawl=0;plug!=null;buffcrawl++){
        plug = buffread.readLine();
        changer.add(buffcrawl, plug);
    }
    String[] chararray = new String[200];
    String[] charz = new String[200];
    int i;
    int j;
    int finalint;
    char charholder;
    String hold = "";
    String s;
    char c;
    int charcrawl;
    boolean numeric = true;
    for(int linecrawl=0;linecrawl<changer.size();linecrawl++) {
        if(changer.get(linecrawl)==null){
            break;
        }
        hold = changer.get(linecrawl);
        for(charcrawl=0;charcrawl<hold.length();charcrawl++){
            c = hold.charAt(charcrawl);
            s = String.valueOf(c);
            chararray[charcrawl] = s;
        }
        hold = chararray.toString();
        if(!hold.contains(",")){
            vertexdec.add(hold);
            break;
        }
        else{
        c = hold.charAt(i);
        s = String.valueOf(c);
            while(s!=","){      
                charholder = hold.charAt(i);
                charz[i]=String.valueOf(charholder);
                i++;
                c = hold.charAt(i);
            s = String.valueOf(c);
            }
            s=charz.toString();
            vertexarray.add(s);
            for(j=0;j<s.length();j++){
                charz[j]=null;
            }
            i++;
            c = hold.charAt(i);
        s = String.valueOf(c);
            while(s!=","){
                charholder = hold.charAt(i);
                charz[i]=String.valueOf(charholder);
                i++;
                c = hold.charAt(i);
            s = String.valueOf(c);
            }
            s=charz.toString();
            edgearray.add(s);
            for(j=0;j<s.length();j++){
                charz[j]=null;
            }
            c = hold.charAt(i);
        s = String.valueOf(c);
            while(s!=null){
                charholder = hold.charAt(i);
                charz[i]=String.valueOf(charholder);
                i++;
                c = hold.charAt(i);
            s = String.valueOf(c);
            }
            s=charz.toString();
            s = s.replaceAll("\\s+","");
            try {
                Double num = Double.parseDouble(s);
            }
            catch (NumberFormatException e) {
                numeric = false;
            }
            if(numeric){
                finalint = Integer.parseInt(s);
                weight.add(finalint);
                for(j=0;j<s.length();j++){
                    charz[j]=null;
                }
                break;
            }
            else{
                numeric=true;
                edgearray.remove(edgearray.size()-1);
                vertexarray.remove(vertexarray.size()-1);
                for(j=0;j<s.length();j++){
                    charz[j]=null;
                }
            }
        }
    }          
    //fix this so nodegraph is a returned arraylist
    ArrayList<String> nodegraph = runner.graph(vertexdec, vertexarray,  edgearray, weight);
    System.out.println("amount of verticies: "+ runner.namevertexs.size());
    String third = "";
    int count = 0;
    int bignum = 0;
    ArrayList<String> noedge = new ArrayList<String>();
    for(i=0;i<nodegraph.size();i++){
        hold = nodegraph.get(i);
        source=runner.vertarr.get(nodegraph.indexOf(hold));
        if(source.edge.size()<1){
            noedge.add(hold);
        }
        else{
            for(j=0;j<nodegraph.size();j++){
                sec=runner.vertarr.get(nodegraph.indexOf(j));
                if(!sec.Containsedge(nodegraph.get(j),hold)){
                    count++;
                }
            }
        if(count==0){
            System.out.println(hold+" has zero inbound edges.");
        }
    }
    count = 0;
    }
    for(i=0;i<nodegraph.vertexs.size();i++){
        hold = nodegraph.vertexs.get(i);
        if(hold.edge.contains(hold)){
            System.out.println(hold+"has a self edge.");
        }
    }
    for(i=0;i<noedge.size();i++){
        System.out.println(noedge.get(i)+"has no edge.");
    }
    for(i=0;i<nodegraph.vertexs.size();i++){
        hold=nodegraph.vertexs.get(i);
        for(j=0;j<hold.weight.size();j++){
            if(bignum<hold.weight.get(j)){
                bignum=hold.weight.get(j);
                sec = hold.edge.get(j);
                third = hold;
            }
        }
    }
    System.out.println("the heaviest edge is from "+third+" to "+sec+" with a weight of "+bignum);
}
}

