package endri.agung.javaclass;

import java.util.ArrayList;

/**
 * Created by D2J-00 on 31/01/2017.
 */
public class transaksi {
    private ArrayList<barang> Listbarang =new ArrayList<>();


    public void addbarang(barang barang)
    {
        this.Listbarang.add(barang);
    }
     public int totaltransaksi(){
         int hasil = 0;
         for(int i=0; i < Listbarang.size();i++)
         {
             hasil +=Listbarang.get(i).getHarga();
         }
         return hasil;
     }

    public String printtransaksi(){
        String text = "barang yang dibeli pada transasksi adalah    :\n";
        text +="\n...................................................\n";

        for(int i= 0; i<Listbarang.size();i++)
        {
            text += Listbarang.get(i).toString();
        }
        text += "\n..................................................\n";
        text += "total pembelian:"+totaltransaksi()+"\n";
        text += "\n...................................................\n";
        return text;
    }




}
