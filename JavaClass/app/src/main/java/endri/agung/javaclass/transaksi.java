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
        text += "rata - rata :"+averagetransaksi()+"\n";
        text += "\n...................................................\n";
        return text;
    }

    public double averagetransaksi()
    {
        double hasil = 0;
        for(int i= 0; i<Listbarang.size();i++)
        {
            hasil += Listbarang.get(i).getHarga();
        }
        hasil=hasil/Listbarang.size();
        return hasil;
    }
    public String maxbarang(){
        barang max;
        max =Listbarang.get(0);
        for(int i= 0; i<Listbarang.size();i++)
        {
            if(Listbarang.get(i).getHarga() > max.getHarga()){
                max = Listbarang.get(i);
            }
        }


        String namabarang = max.getNama();
        String text = "barang termahal pada transaksi adalah "+namabarang;
        return text;
    }





}
