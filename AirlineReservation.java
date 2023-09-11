package com.PentagonSpace;

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AirlineReservation extends JFrame {
        JTabbedPane Tp=new JTabbedPane();

        CardLayout C=new CardLayout();
        JPanel Jp1=new JPanel();
        JPanel Jp2=new JPanel();
        JPanel rough=new JPanel();

    JPanel main=new JPanel();
    JPanel card=new JPanel();
    JPanel Jp3=new JPanel();

    JTextField fName=new JTextField(10);
    JTextField LName=new JTextField(10);
    JTextField PassportId=new JTextField(10);
    JTextField DOB=new JTextField(10);
    JTextField Contact=new JTextField(10);

    ButtonGroup gb=new ButtonGroup();
    JRadioButton g1=new JRadioButton("Male");
    JRadioButton g2=new JRadioButton("Female");
    JRadioButton g3=new JRadioButton("Other");
    JTextArea address=new JTextArea("Enter the Current Address",4,20);

    String genderText;
    JButton adduser=new JButton("Add");
    JButton cancelUser=new JButton("Back");
    JButton newUser=new JButton("New User");
    JButton userLogin=new JButton("Login");
     Connection Conn;
     Statement stat;
     ResultSet rs;

    JPanel JP4=new JPanel();
    JTextField JTp4=new JTextField(20);
    JTextField JTp5=new JTextField(20);
    JButton login=new JButton("Login");
    JButton cancel=new JButton("Cancel");

    JPanel EMP=new JPanel();
    CardLayout C1=new CardLayout();
    JPanel EJp=new JPanel();
    JTextField EJTp4=new JTextField(20);
    JTextField EJTp5=new JTextField(20);
    JButton ELogin=new JButton("Login");
    JButton ECancel=new JButton("Cancel");

    JPanel EJp1=new JPanel();
    JPanel EJp2=new JPanel();
    JButton search=new JButton("Search");
    JTextField flightSearch=new JTextField(20);
    JPanel EJp3=new JPanel();
    JTextField Date=new JTextField(20);
    JTextField FlightId=new JTextField(20);
    JTextField flightName=new JTextField(20);
    Choice source=new Choice();
    Choice Departure =new Choice();

    String[] SourceChoice={"India","UK","Chin","New Delhi","Hyderabad","Chennai","Kolkata",
                            "Bengaluru","Rajkot","Ranchi",
                            "Amritsar","Chandigarh","Madurai",
                            "Visakhapatnam","Nagpur"};
    JTextField ArrivalTime = new JTextField(20);
    JTextField DepartureTime = new JTextField(20);
    JTextField flightCharges = new JTextField(20);

    JPanel EJp4=new JPanel();
    JButton FlightAdd= new JButton("Add Flight");
    JButton FlightUpdate= new JButton("Update Details");
    JButton FBack= new JButton("Cancel");
    JPanel EJp5=new JPanel();
    JButton AddUser=new JButton("New User");
    JPanel AddNewUser=new JPanel();
    JPanel AddNewUser1=new JPanel();
    JPanel AddNewUser2=new JPanel();
    JButton Back=new JButton("Cancel");
    JButton AddEMP=new JButton("Add");
    JTextField Company_Name=new JTextField(20);
    JTextField Emp_Name=new JTextField(20);
    JTextField Emp_Id=new JTextField(20);
    JTextField Emp_Password=new JTextField(20);
    JTextField Emp_Email=new JTextField(20);

    JPanel Booking_Panel=new JPanel();
    JPanel Booking_Panel1=new JPanel();
    Choice From=new Choice();
    Choice To= new Choice();
    JTextField FDate=new JTextField(20);
    JButton SearchFlight=new JButton("Search");
    JPanel Booking_Panel2=new JPanel();
    JTable AvailableFlight=new JTable();
    JScrollPane SPFlight=new JScrollPane(AvailableFlight);
    JPanel Booking_Panel3=new JPanel();
    JTextField BTicketNo=new JTextField(20);

    final int x=1;
    JTextField BFlightId=new JTextField(20);
    JTextField BPassportId=new JTextField(20);
    JTextField BDepartureTime=new JTextField(20);
    JTextField BArrivalTime=new JTextField(20);
    Choice BClass=new Choice();
    String[] FClass={"Economy","Business","Premium Economy","First Class"};
    JTextField BPrice=new JTextField(20);
    JTextField BSeats=new JTextField(20);
    JTextField BPassengerName=new JTextField(20);
    JTextField BDate=new JTextField(20);

    String FID,fDate,arrTime,DTime,Price;
    JButton Book=new JButton("Book");
    JButton CancelBook=new JButton("Cancel");

    JPanel Booking_Panel4=new JPanel();
    JButton PreviousBooking= new JButton("Previous Bookings");
    JPanel PreviousBooking1= new JPanel();
    JTable Booked=new JTable();
    JScrollPane JSp=new JScrollPane(Booked);
    ResultSet rs1;
    JPanel PreviousBooking2= new JPanel();

    JButton DeleteBooking= new JButton("Cancel Bookings");
    JButton BackToBocking= new JButton("Back");

    AirlineReservation(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            System.out.println("Driver Resister.....");
            Conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinereservation",
                    "root","tiger");
            stat=Conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        setBounds(100,100,900,600);
        setTitle("Welcome to Airline Reservation");
        for(int i=0;i<FClass.length;i++){
            BClass.add(FClass[i]);
        }
        for(int i=0;i<SourceChoice.length;i++){
            source.add(SourceChoice[i]);
            Departure.add(SourceChoice[i]);
            From.add(SourceChoice[i]);
            To.add(SourceChoice[i]);
        }
        main.add(new JLabel("Register As new User :- "));
        main.add(newUser);
        main.add(new JLabel("Already have an Account :- "));
        main.add(userLogin);
        add(main);
        Jp1.setLayout(new BorderLayout());
        Jp2.setLayout(new GridLayout(7,2));
        Jp2.add(new JLabel("First Name : "));
        Jp2.add(fName);
        Jp2.add(new JLabel("Last Name : "));
        Jp2.add(LName);
        Jp2.add(new JLabel("Passport Id : "));
        Jp2.add(PassportId);
        Jp2.add(new JLabel("Address : "));
        Jp2.add(address);
        Jp2.add(new JLabel("Date of Birth : "));
        Jp2.add(DOB);
        Jp2.add(new JLabel("Gender : "));
         gb.add(g1);
         gb.add(g2);
         gb.add(g3);
         rough.add(g1);
        rough.add(g2);
        rough.add(g3);
         Jp2.add(rough);
        Jp2.add(new JLabel("Contact No. : "));
        Jp2.add(Contact);
        Jp1.add(Jp2,"Center");

        Jp3.add(adduser);
        Jp3.add(cancelUser);
        Jp1.add(Jp3,"South");

        JP4.add(new JLabel("Name : "));
        JP4.add(JTp4);
        JP4.add(new Label("PassportId"));
        JP4.add(JTp5);
        JP4.add(login);
        JP4.add(cancel);

        Booking_Panel1.setSize(600,400);
        Booking_Panel1.add(new JLabel("From : "));
        Booking_Panel1.add(From);
        Booking_Panel1.add(new JLabel("To : "));
        Booking_Panel1.add(To);
        Booking_Panel1.add(new JLabel("Date : "));
        Booking_Panel1.add(FDate);
        Booking_Panel1.add(SearchFlight);
        Booking_Panel2.add(SPFlight);

        Booking_Panel3.setLayout(new GridLayout(11,2));
        Booking_Panel3.add(new JLabel("Ticket No"));
        BTicketNo.setEditable(false);
        BTicketNo.setText(String.valueOf(x));
        Booking_Panel3.add(BTicketNo);
        Booking_Panel3.add(new JLabel("Flight Id"));
        BFlightId.setEditable(false);
        BDate.setEditable(false);
        BArrivalTime.setEditable(false);
        BDepartureTime.setEditable(false);
        BPrice.setEditable(false);
       AvailableFlight.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               int a=AvailableFlight.getSelectedRow();
               fDate=String.valueOf(AvailableFlight.getValueAt(a,0));
               FID=String.valueOf(AvailableFlight.getValueAt(a,1));
               arrTime=String.valueOf(AvailableFlight.getValueAt(a,5));
               DTime=String.valueOf(AvailableFlight.getValueAt(a,6));
               Price=String.valueOf(AvailableFlight.getValueAt(a,7));
               BFlightId.setText(FID);
               BDate.setText(fDate);
               BArrivalTime.setText(arrTime);
               BDepartureTime.setText(DTime);
               BPrice.setText(Price);
           }
       });
        Booking_Panel3.add(BFlightId);
        Booking_Panel3.add(new JLabel("Date"));
        Booking_Panel3.add(BDate);
        Booking_Panel3.add(new JLabel("Passenger Name"));
        Booking_Panel3.add(BPassengerName);
        Booking_Panel3.add(new JLabel("Passport Id"));
        Booking_Panel3.add(BPassportId);
        Booking_Panel3.add(new JLabel("Arrival Time"));
        Booking_Panel3.add(BArrivalTime);
        Booking_Panel3.add(new JLabel("Departure Time"));
        Booking_Panel3.add(BDepartureTime);
        Booking_Panel3.add(new JLabel("Class"));
        Booking_Panel3.add(BClass);
        Booking_Panel3.add(new JLabel("Price"));
        Booking_Panel3.add(BPrice);
        Booking_Panel3.add(new JLabel("Seats"));
        Booking_Panel3.add(BSeats);
        Booking_Panel3.add(Book);
        Booking_Panel3.add(CancelBook);

        Booking_Panel4.add(PreviousBooking);
        Booking_Panel4.add(DeleteBooking);

        Booking_Panel.setLayout(new BorderLayout());
        Booking_Panel.add("North",Booking_Panel1);
        Booking_Panel.add("Center",Booking_Panel2);
        Booking_Panel.add("East",Booking_Panel3);
        Booking_Panel.add("South",Booking_Panel4);
        PreviousBooking1.setLayout(new BorderLayout());
        PreviousBooking1.add("Center",JSp);
        PreviousBooking2.add(DeleteBooking);
        PreviousBooking2.add(BackToBocking);
        PreviousBooking1.add("South",PreviousBooking2);

        card.setLayout(C);
        card.add("main_Card",main);
        card.add("New_UserCard",Jp1);
        card.add("Login_Card",JP4);
        card.add("Booking_Card",Booking_Panel);
        card.add("PreviousBooked",PreviousBooking1);


        Tp.addTab("User",card);
        PreviousBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                C.show(card,"PreviousBooked");
            }
        });

        EJp.add(new JLabel("Name : "));
        EJp.add(EJTp4);
        EJp.add(new Label("Password"));
        EJp.add(EJTp5);
        EJp.add(ELogin);
        EJp.add(ECancel);

        EJp1.setLayout(new BorderLayout());
        EJp2.add(new JLabel("Search Flight"));
        EJp2.add(flightSearch);
        EJp2.add(search);

        EJp3.setLayout(new GridLayout(8,2));


        EJp3.add(new JLabel("Date :"));
        EJp3.add(Date);
        EJp3.add(new JLabel("Flight Id :"));
        EJp3.add(FlightId);
        EJp3.add(new JLabel("Flight Name :"));
        EJp3.add(flightName);
        EJp3.add(new JLabel("Source :"));
        EJp3.add(source);
        EJp3.add(new JLabel("Departure :"));
        EJp3.add(Departure);
        EJp3.add(new JLabel("Arrival Time :"));
        EJp3.add(ArrivalTime);
        EJp3.add(new JLabel("Departure Time :"));
        EJp3.add(DepartureTime);
        EJp3.add(new JLabel("Charges :"));
        EJp3.add(flightCharges);


        EJp4.add(FlightAdd);
        EJp4.add(FlightUpdate);
        EJp4.add(FBack);
        AddNewUser1.setLayout(new GridLayout(5,2));
        AddNewUser1.add(new JLabel("Company Name:"));
        AddNewUser1.add(Company_Name);
        AddNewUser1.add(new JLabel("Employee Name:"));
        AddNewUser1.add(Emp_Name);
        AddNewUser1.add(new JLabel("Employee Id"));
        AddNewUser1.add(Emp_Id);
        AddNewUser1.add(new JLabel("Password:"));
        AddNewUser1.add(Emp_Password);
        AddNewUser1.add(new JLabel("Email:"));
        AddNewUser1.add(Emp_Email);

        AddNewUser2.add(Back);
        AddNewUser2.add(AddEMP);
        AddNewUser.setLayout(new BorderLayout());
        AddNewUser.add("Center",AddNewUser1);
        AddNewUser.add("South",AddNewUser2);

        EJp5.add(AddUser);

         EJp1.add("North",EJp2);
         EJp1.add("Center",EJp3);
         EJp1.add("South",EJp4);
         EJp1.add("East",EJp5);

        EMP.setLayout(C1);
        EMP.add("Login_Card",EJp);
        EMP.add("EMP_Card",EJp1);
        EMP.add("NewEMP_Card",AddNewUser);


        Tp.addTab("Services",EMP);
        add(Tp);

        g3.addActionListener(e -> genderText="Other");
        g2.addActionListener(e -> genderText="Female");
        g1.addActionListener(e -> genderText="Male");
        newUser.addActionListener(e -> C.show(card,"New_UserCard"));

        adduser.addActionListener(e -> {
            String userData="Insert into airlinereservation.customer values('"+
                    fName.getText()+"','"+LName.getText()+"','"+PassportId.getText()+
                    "','"+address.getText()+"','"+DOB.getText()+"','"+genderText +
                    "','"+Contact.getText()+"');";
         //   System.out.println(userData);

            String UserBook="create table "+
                "Passenger_"+fName.getText()+"(TicketNo Varchar(10) ," +
                "Flight_Id Varchar(10)," +
                "PDate Varchar(20)," +
                "Passenger_Name Varchar(30)," +
                " Passport_Id Varchar(20)," +
                "Arrival_Time Varchar(10)," +
                "Departure_Time Varchar(10)," +
                "Class Varchar(20)," +
                "Price Varchar(20)," +
                "Seats Varchar(20)); ";
            System.out.println(UserBook);
             try {
                 stat.execute(userData);
                 stat.execute(UserBook);

                 JOptionPane.showMessageDialog(null, "Successfully Registered");
             }
             catch (Exception e1){
                 e1.printStackTrace();
             }
            fName.setText("");
            LName.setText("");
            PassportId.setText("");
            address.setText("");
            DOB.setText("");
            Contact.setText("");
        });

        userLogin.addActionListener(e -> C.show(card,"Login_Card"));

        login.addActionListener(e -> {
            String loginSql="Select fName from customer where fName='"+
                    JTp4.getText()+"'AND passportId='"+JTp5.getText()+"';";

            String loginSql1="Select * from Passenger_"+JTp4.getText()+" where Passenger_Name='"+
                    JTp4.getText()+"'AND Passport_Id='"+JTp5.getText()+"';";
            System.out.println(loginSql);

                try{
                    rs=stat.executeQuery(loginSql);
                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null, "Successfully Login !");
                        C.show(card,"Booking_Card");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Credentials!");
                    }
                   rs1=stat.executeQuery(loginSql1);
                //    System.out.println(loginSql1);
                        Booked.setModel(DbUtils.resultSetToTableModel(rs1));
                        PreviousBooking1.add("Center", JSp);
                }
                catch (Exception e2){
                    e2.printStackTrace();
                }
        });
        cancel.addActionListener(e -> C.show(card,"main_Card"));

        cancelUser.addActionListener(e -> C.show(card,"main_Card"));

        ELogin.addActionListener(e -> {
            String loginSql="Select EName from employer where EName='"+
                    EJTp4.getText()+"'AND Password='"+EJTp5.getText()+"';";

        //    System.out.println(loginSql);
            try{
                rs=stat.executeQuery(loginSql);
                if(rs.next()) {
                    JOptionPane.showMessageDialog(null, "Successfully Login !");
                    C1.show(EMP,"EMP_Card");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Credentials!");
                }
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        });

        FlightAdd.addActionListener(e -> {
            String UserAdd="Insert into flightdetails values('"+Date.getText()+"','"
                    +FlightId.getText()+"','"+flightName.getText()+"','"+source.getSelectedItem()
                    +"','"+Departure.getSelectedItem()+"','"+ArrivalTime.getText()+
                    "','"+DepartureTime.getText()+"','"+flightCharges.getText()+"')";

//                System.out.println(UserAdd);
            try{
                stat.execute(UserAdd);
                JOptionPane.showMessageDialog(null, "Flight Record is inserted");
                Date.setText("");
                FlightId.setText("");
                flightName.setText("");
                ArrivalTime.setText("");
                DepartureTime.setText("");
                flightCharges.setText("");


            }catch (Exception e2){
                e2.printStackTrace();
            }
        });
        search.addActionListener(e -> {
            String SearchSql="SELECT * FROM flightdetails WHERE Flight_Id='"+flightSearch.getText()+"';";
//                System.out.println(UserAdd);
            try{
                rs=stat.executeQuery(SearchSql);
                if(rs.next()){
                    Date.setText(rs.getString(1));
                    FlightId.setText(rs.getString(2));
                    flightName.setText(rs.getString(3));
                    source.select(rs.getString(4));
                    Departure.select(rs.getString(5));
                    ArrivalTime.setText(rs.getString(6));
                    DepartureTime.setText(rs.getString(7));
                    flightCharges.setText(rs.getString(8));
                }
                else {
                    JOptionPane.showMessageDialog(null, "Such Flight Not Found Please Enter the Correct Flight_Id...");
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        });
        FlightUpdate.addActionListener(e -> {
            String Update="Update flightdetails set Date='"+Date.getText()+
                    "',flightName= '"+flightName.getText()+"', Source='"
                    +source.getSelectedItem()+"', Departure_Place='"+
                    Departure.getSelectedItem()+"', Arrival_Time='"+
                    ArrivalTime.getText()+"',Departure_Time='"+DepartureTime.getText()
                    +"',Flight_Charges='"+ flightCharges.getText()
                    +"' where Flight_Id='"+flightSearch.getText()+"';";

            Date.setText("");
            FlightId.setText("");
            flightName.setText("");
            ArrivalTime.setText("");
            DepartureTime.setText("");
            flightCharges.setText("");
//                System.out.println(Update);

            try{
                stat.executeUpdate(Update);
                JOptionPane.showMessageDialog(null, "Successfully Updated...");
            }catch (Exception e2){
                e2.printStackTrace();
            }

        });

        AddUser.addActionListener(e -> C1.show(EMP,"NewEMP_Card"));
        Back.addActionListener(e -> C1.show(EMP, "EMP_Card"));
        AddEMP.addActionListener(e -> {
            String EmpAdd="Insert Into employer values('"+Company_Name.getText()+
                    "','"+Emp_Name.getText()+"','"+Emp_Id.getText()+"','"+
                    Emp_Password.getText()+"','"+Emp_Email.getText()+"');";
//                System.out.println(EmpAdd);
            try {
                stat.execute(EmpAdd);
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
            Company_Name.setText("");
            Emp_Name.setText("");
            Emp_Id.setText("");
            Emp_Password.setText("");
            Emp_Email.setText("");


        });
        SearchFlight.addActionListener(e -> {
            String Flight="Select * from flightdetails where Source='"+
                    From.getSelectedItem()+"' And Departure_Place='"+To.getSelectedItem()
                    +"' And Date='"+FDate.getText()
                    +"';";
          //  System.out.println(Flight);
            try {
                rs = stat.executeQuery(Flight);
                AvailableFlight.setModel(DbUtils.resultSetToTableModel(rs));


                if(rs==null) {
                    JOptionPane.showMessageDialog(null, "Sorry No Flight Available!");
                }
            }
            catch (Exception e1){
                e1.printStackTrace();
            }

        });
        Book.addActionListener(e -> {
            String Booking="Insert Into Passenger_"+JTp4.getText()+" Values('"+BTicketNo.getText()+"','"+BFlightId.getText()+"','"
                    +BDate.getText()+"','"+BPassengerName.getText()+"','"+BPassportId.getText()
                    +"','"+BArrivalTime.getText()+"','"+BDepartureTime.getText()
                    +"','"+BClass.getSelectedItem()+"','"+BPrice.getText()+"','"
                    +BSeats.getText()+"');";

           // System.out.println(Booking);
            try {
                stat.execute(Booking);
                JOptionPane.showMessageDialog(null, "Successfully Booked...");
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
            BTicketNo.setText(" ");
            BFlightId.setText(" ");
            BDate.setText(" ");
            BPassengerName.setText(" ");
            BPassportId.setText(" ");
            BArrivalTime.setText(" ");
            BDepartureTime.setText(" ");
            BPrice.setText(" ");
            BSeats.setText(" ");
        });
        CancelBook.addActionListener(e -> {
            C.show(card,"Login_Card");
        });
        DeleteBooking.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int a=Booked.getSelectedRow();
                String Passenger_Name, Passport_Id;
                Passenger_Name=String.valueOf(Booked.getValueAt(a,3));
                Passport_Id=String.valueOf(Booked.getValueAt(a,4));
                String deleteSql="Delete From Passenger_"+JTp4.getText()+" where Passenger_Name='"+
                        Passenger_Name+"' AND Passport_Id='"+Passport_Id+"';";
                System.out.println(deleteSql);
                try {
                    stat.execute(deleteSql);
                    JOptionPane.showMessageDialog(null, "Successfully Cancelled...");
                    PreviousBooking1.add("Center", JSp);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        BackToBocking.addActionListener(e -> {
            C.show(card,"Booking_Card");
        });
        FBack.addActionListener(e -> C1.show(EMP,"Login_Card"));
    }
    public static void main(String[] args) {
        AirlineReservation ALR=new AirlineReservation();
        ALR.setVisible(true);
        ALR.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
