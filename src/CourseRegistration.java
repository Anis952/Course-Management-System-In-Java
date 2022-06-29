import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CourseRegistration {


    public static void main(String[] args) {
        System.out.println("|========Registration Managment system==================|");
        System.out.println("|__________  1. Student ________________________________|");
        System.out.println("|__________   Select Course ____________________________|");
        System.out.println("|             1.BBA                                     |");
        System.out.println("|             2.BIT                                     |");
        System.out.println("|__________  2. Registration ___________________________|");
        System.out.println("|                                                       |");
        System.out.println("|                                                       |");
        System.out.println("|__________  3. instructor ____________________________ |");

        Scanner myobj = new Scanner(System.in);
        System.out.println("Select your choice");

        int userType = myobj.nextInt();

        if (userType == 1) {
            Student sObj = new Student();
            System.out.println("-----Registration process---------");
            sObj.register();

            CourseRegistration aObj = new CourseRegistration();
            aObj.Course();
            System.out.println("\n--------Select Course-----");
            Course obj = new Course();

            Scanner sc = new Scanner(System.in);
            int course = sc.nextInt();
            switch (course) {
                case 1:
                    Course BBAsc = new BBA();
                    BBAsc.level();
                case 2:
                    Course BITsc = new BIT();
                    BITsc.level();

            }

            Module sOnj = new Module();
            sOnj.select();

        }
        if (userType == 2) {
            Registration xObj = new Registration();
            System.out.println("------View Module registered by student------");
           // xObj.course();
            xObj.addCourse();
            try {
                xObj.deleteCourse();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (userType == 3) {
           Instructor aObj = new Instructor();
            Scanner sc = new Scanner(System.in);
            int Instructor = sc.nextInt();
            System.out.println("select your choice : \n 1.Add modules \n 2.view what modules they are on \n 3.Add marks on module");
          switch(Instructor){
              case 1:
                  aObj.assigned();
              case 2:
                  aObj.addMototeach();
              case 3:
                  aObj.addMarks();



          }
        }
    }

     static class Instructor{


  public  void addMototeach(){
      ArrayList module = new ArrayList();
      boolean token = true;
      Scanner sc1 = new Scanner(System.in);
      module.add(sc1.next());
      while (token) {

          System.out.println("Enter the Module to teach");
          module.add(sc1.next());


          if (!(sc1.nextInt() == 1)) {
              token = false;
          }
      }
      try {
          File f =  new File("module.txt");
          f.createNewFile();
          FileWriter fw = new FileWriter("module.txt");

      } catch (IOException e) {
          e.printStackTrace();
      }

  }

         public void addMarks() {


             ArrayList al = new ArrayList();
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter the marks for Module");
             String mod = sc.next();
             try {
                 FileReader fr = new FileReader("module.txt");

                 Scanner scfr = new Scanner(fr);

                 while (scfr.hasNext()) {
                     String s1 = scfr.nextLine();
                     System.out.println(s1);
                     String s = sc.next();
                     al.add(s + "\t" + s1);
                 }
                 System.out.println(al);

             } catch (IOException e) {

                 System.out.println("file not found");

             }
         }



        public void assigned(){
            ArrayList al = new ArrayList();
            Scanner sc = new Scanner(System.in);


            try {


                FileReader f1;
                f1 = new FileReader("studentdetail.txt");
                Scanner z = new Scanner(f1);
                //  String[] s1 = sc.nextLine().split("\t");
                //  int j;
                while (z.hasNext()){
                    System.out.println(z.nextLine());
                }



                //  while ((j = f1.read()) != -1) {
                //     System.out.println((char) j);

                //       System.out.println("\t" + s1[1]);
                // }
            } catch (IOException e) {
                System.out.println("File not found");
            }



        }



















    }

    private void Course() {
    }
}


class Course{

    public void level()  {
        System.out.println("_____select your course______");

    }


}
class BBA extends Course{
    public void level() {
        System.out.println("\n level 4 \n level5 \n level6");
        try {

            FileReader f2 = new FileReader("BBA.txt");
            Scanner sc = new Scanner(f2);
            //  String[] s1 = sc.nextLine().split("\t");
            //  int j;
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }


            //  while ((j = f1.read()) != -1) {
            //     System.out.println((char) j);

            //       System.out.println("\t" + s1[1]);
            // }
        } catch (IOException e) {
            System.out.println("File not found");


        }

    }
}


class BIT extends Course {
    public void level() {
        System.out.println("\nlevel4 \nlevel5 \nlevel6");
        try {


            FileReader f1 = new FileReader("BIT.txt");
            Scanner sc = new Scanner(f1);
         //  String[] s1 = sc.nextLine().split("\t");
          //  int j;
            while (sc.hasNext()){
                System.out.println(sc.nextLine());
            }



          //  while ((j = f1.read()) != -1) {
           //     System.out.println((char) j);

        //       System.out.println("\t" + s1[1]);
           // }
        } catch (IOException e) {
            System.out.println("File not found");
        }


    }


}


class Student {
    public void register(){
        ArrayList al = new ArrayList();
        Scanner sc = new Scanner(System.in);
        System.out.println(" welcome to Registration:\n");

        System.out.println("Enter your full name:\n");
        al.add(sc.next());

        System.out.println("Enter your address:\n");
        al.add(sc.next());

        System.out.println("Enter your gmail:\n");
        al.add(sc.next());

        try {


            File f1 = new File("studentdetail.txt");
            f1.createNewFile();
            FileWriter myFile = new FileWriter("studentdetail.txt", true);
            Iterator itr = al.iterator();
            while (itr.hasNext()) {
                myFile.write((String) itr.next() +   "\n");
            }
            myFile.close();

        } catch (IOException e){
            System.out.println("File not found");
        }

    }


}



class Module{

public void select (){
    ArrayList Module = new ArrayList();
    Scanner sc = new Scanner(System.in);


    System.out.println("Module no 1");
    Module.add(sc.nextLine());

    System.out.println("Module no 2");
    Module.add(sc.nextLine());


    System.out.println("Module no 3 ");
    Module.add(sc.nextLine());





    try {


        FileWriter myFile = new FileWriter("studentdetail.txt", true);
        Iterator itr = Module.iterator();
        while (itr.hasNext()) {

            myFile.write((String) itr.next() +   "\n");
            System.out.println(sc.nextLine());
        }
        myFile.close();

    } catch (IOException e){
        System.out.println("File not found");
    }



}

}

class Registration {
    //  public void course() {

    //    try {
    // File fr = new File("course.txt");
    //   Scanner sc = new Scanner(fr);
    // System.out.println("--Given course are---");

    // while (sc.hasNextLine()) ;
    //  {
    //    System.out.println(sc.hasNextLine());

    //}
    //Thread.sleep(2000);
    //  } catch (FileNotFoundException o)
    // {
    //System.out.println("file error");
    //} catch (InterruptedException e) {
    // e.printStackTrace();
    //}
    //}

    public void addCourse() {

        ArrayList course = new ArrayList();
        ArrayList module = new ArrayList();
        boolean token = true;
        Scanner sc = new Scanner(System.in);
        course.add(sc.next());
        while (token) {

            System.out.println("Enter the Course Name");
            course.add(sc.next());


            System.out.println("do you want to add course?\n1.yes \n2.No");
            if (!(sc.nextInt() == 1)) {
            token = false;
        }
    }
        try {
            File f =  new File("course.txt");
            f.createNewFile();
            FileWriter fw = new FileWriter("course.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void deleteCourse() throws IOException {
        Scanner strInput =  new Scanner(System.in);
        String ID, record;


        File tempDB = new File("course.txt");
        File db = new File("course.txt");


        BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );


        System.out.println("\t\t Delete course\n");

        System.out.println("Enter the Course  ID: ");
        ID =  strInput.nextLine();


        while( ( record = br.readLine() ) != null ) {


            if( record.contains(ID) )
                continue;

            bw.write(record);
            bw.flush();
            bw.newLine();

        }

        br.close();
        bw.close();

        db.delete();


    }

    }


























