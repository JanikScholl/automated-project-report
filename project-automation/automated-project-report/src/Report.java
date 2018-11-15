//Report class. Containing all information about the report like: FloorCount and IncludedPages...

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.Date;

public class Report {

    //boolean if this page is included in the report or not
    //Todo: write initialisation and expand constructor
    private boolean titelPage=true, quickInfoPage=true, managementSummaryPage=true,obersvationAreaPage=true, geometryPage=true, passangerFlowsPage=true, generealSimulationAssumptionsPage=true;
    private boolean resultsPage=true, specialPages=true, evakuationDurationPage=true, summaryPage=true, referencesPage=true;


    //Project spezific information
    private String clientInfo, taskInfo,authorInfo;
    private String dateInfo;


    //Date is set upon creating the ReportObj
    Report()
    {
        //Setting the current date (https://www.javatpoint.com/java-date-to-string)
        Date date= Calendar.getInstance().getTime();
        DateFormat dateFormat=new SimpleDateFormat("dd.mm.yyyy");
        this.dateInfo=dateFormat.format(date);

    };


//Get functions, returning if this page should be printed or not
    public boolean getTitelPage() { return this.titelPage; }
    public boolean getQuickInfoPage() { return this.quickInfoPage; }
    public boolean getManagementSummaryPage() { return this.managementSummaryPage; }
    public boolean getObervationAraePage() { return this.obersvationAreaPage; }
    public boolean getGeometryPage() { return this.geometryPage; }
    public boolean getPassangerFlowsPage() { return this.passangerFlowsPage; }

    public String getDateInfo()
    {
        String string=this.dateInfo;
        return string;
    }
}
