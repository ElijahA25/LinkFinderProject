import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class LinkFind {
    public String finalString = "";

    public static void main(String[] args) {
        LFGUI l = new LFGUI();
    }
    public LinkFind(String pLink, String pKeyword) {
        String link = pLink;
        String keyword = pKeyword;

        try {
            URL url = new URL(link);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            boolean anyKeywords = false;
            while ((line = reader.readLine()) != null) {
                if (line.contains("href=") && line.contains(keyword) && line.contains("https://")) {
                    anyKeywords = true;
                    System.out.println(line);
                    int indexAHref = line.indexOf("href=\"");
                    int indexQuote = line.indexOf("\">");
                    int indexKeyword = line.indexOf(keyword);
                    int endIndex = line.indexOf("\">",indexKeyword+keyword.length());
                    if(endIndex>-1 && endIndex>indexQuote && !line.contains("aria-current=\"page")) {
                        String string2 = line.substring(indexAHref, endIndex);
                        finalString = finalString + "\n" + string2.substring(6);
                        //System.out.println(string2);
                        //System.out.println(string2.substring(9));

                    }

                }

//                if(line.contains("href=") && line.contains(keyword) && line.contains("https://") == false && line.contains("<a href")==false){
//                    anyKeywords = true;
//                    int indexHref = line.indexOf("href=");
//                    int indexQuote = line.indexOf("\">");
//                    System.out.println(line);
//                    String incString = line.substring(indexHref+5,indexQuote);
//                    finalString = finalString+"\n"+link + incString;
//
//
//
//                }


            }
            reader.close();
            if(anyKeywords == false){
                finalString = "NO KEYWORDS FOUND";

            }
            System.out.println(finalString);



                } catch (Exception e) {
                    System.out.println(e);
                }

            }


    }
