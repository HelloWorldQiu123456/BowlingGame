import java.util.ArrayList;

public class BowlingGame {



    public int getBowlingScore(String bowlingCode) {

        String[] str = bowlingCode.split("\\|");
        int sum=0;
        int[] flag=new int[10];
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=0;i<str.length-1;i++)
        {
            char[] arr=str[i].toCharArray();
            if(arr.length==1) {flag[i]=1;}
            if(arr.length==2) {flag[i]=2;}

            for(int j=0;j<arr.length;j++)
            {
                if(arr[j]=='X')
                {
                    list.add(10);
                    break;
                }
                if(arr[j]==' ')
                {
                    break;
                }
                if(arr[j]=='-')
                {
                    list.add(0);
                    flag[i]=3;
                    continue;
                }
                if(Character.getNumericValue(arr[j])<10&&Character.getNumericValue(arr[j])>0)
                {
                    list.add(Character.getNumericValue(arr[j]));

                }
                if(arr[j]=='/')
                {
                    list.add(10-list.get(list.size()-1));
                }
            }

        }

        char[] last=str[str.length-1].toCharArray();
        for(int k=0;k<last.length;k++)
        {
            if(last[k]==' ')
            {
                list.add(0);


            }
            if(last[k]=='X')
            {
                list.add(10);
            }
            if(Character.getNumericValue(last[k])<10&&Character.getNumericValue(last[k])>0)
            {
                list.add(Character.getNumericValue(last[k]));
            }
            if(last[k]=='-')
            {
                flag[str.length-1]=3;
                list.add(0);
                list.add(0);
                list.add(0);
            }
        }




          ArrayList<Integer> sumlist=new ArrayList<Integer>();

        int j=0;
        for(int i=0;i<list.size()-2;) {

            if (flag[j] == 1) {
                int value = list.get(i) + list.get(i + 1) + list.get(i + 2);
                sumlist.add(value);
                j++;
                i++;
            }else
            {
                if (flag[j] == 2) {
                    int value = list.get(i) + list.get(i + 1) + list.get(i + 2);
                    sumlist.add(value);
                    j++;
                    i = i + 2;
                }else
                {
                    int value = list.get(i) + list.get(i + 1);
                    sumlist.add(value);
                    j++;
                    i = i + 2;
                }

            }

        }


        for(int i=0;i<sumlist.size();i++)
        {


            sum=sum+sumlist.get(i);


        }




        return sum;
    }

}
