import java.sql.Connection;
import java.util.List;

import dao.DataAccess;
import dao.SurveyInformationDao;
import model.SurveyInformation;

public class test {
	public static void main(String args[]) {
		Connection con = DataAccess.getConnection();
		List<SurveyInformation> surveyList = SurveyInformationDao.fitlerStatus(con, 0);
		for (SurveyInformation survey: surveyList) {
			System.out.println(survey.getSurveyName());
		}
		
		DataAccess.closeQuietly(con);
	}
}
