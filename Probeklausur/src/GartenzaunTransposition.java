public class GartenzaunTransposition {


    char[] verschluesseln(char[] klartext){
        char[] verText = new char[klartext.length];
        int k = 0;

        for(int i = 0; i < klartext.length; i++){
            System.out.print(klartext[i]);
            verText[k] = klartext[i];
            k++;
            i++;
        }
        for(int i = 1; i < klartext.length; i++){
            System.out.print(klartext[i]);
            verText[k] = klartext[i];
            k++;
            i++;
        }
        System.out.println();
        return verText;
    }


    char[] entschluesseln(char[] geheimtext){
        char[] entText = new char[geheimtext.length];
        int x = 0;

        for(int i = 0; i < (geheimtext.length + 1)/2; i++){
            System.out.print(geheimtext[i]);
            entText[x] = geheimtext[i];
            x++;

            int k = i + (geheimtext.length+1)/2;
            if(k < geheimtext.length){
                System.out.print(geheimtext[k]);
                entText[x] = geheimtext[k];
                x++;
            }

        }

        return entText;
    }
}
