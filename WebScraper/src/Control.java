import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JFileChooser;


public class Control {
	
	Model model;
	View view;
	private String siteList; 
	
	public Control(Model model, final View view) {
		this.model = model;
		this.view = view;
		
		view.chooseFile.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				chooseSiteFile();
			}
		});
		
		view.run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.report.append("Start fetching site description\n");
				fetchDescription();
				view.report.append("Done fetching site description\n");
				view.report.append("Start fetching site data\n");
				fetchData();
				view.report.append("Done fetching site data\n");
			}
		});
	}
	
	protected void chooseSiteFile() {
		JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		
		int returnVal = fc.showOpenDialog(view.chooseFile);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
            siteList = file.getName();
            view.report.setText("Get site list from " + file.getName() + "." + "\n");
            view.run.setEnabled(true);
        } else {
        	view.report.append("Open command cancelled by user." + "\n");
        }
	}
	
	public void fetchDescription() {
		try {
			String inputLine;

			//save to this filename
			File file = new File("site_description.csv");
			file.createNewFile();
			
			// get cite list from this file
			File citeFile = new File(siteList);
			BufferedReader br = new BufferedReader(new FileReader(citeFile));
			
			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("agency_cd,site_no,station_nm,site_tp_cd," +
					"lat_va,long_va,dec_lat_va,dec_long_va," +
					"coord_meth_cd,coord_acy_cd,coord_datum_cd," +
					"dec_coord_datum_cd,district_cd,state_cd," +
					"county_cd,country_cd,land_net_ds,map_nm," +
					"map_scale_fc,alt_va,alt_meth_cd,alt_acy_va," +
					"alt_datum_cd,huc_cd,basin_cd,topo_cd," +
					"data_types_cd,instruments_cd,construction_dt," +
					"inventory_dt,drain_area_va,contrib_drain_area_va," +
					"tz_cd,local_time_fg,reliability_cd,gw_file_cd," +
					"nat_aqfr_cd,aqfr_cd,aqfr_type_cd,well_depth_va," +
					"hole_depth_va,depth_src_cd,project_no," +
					"rt_bol,peak_begin_date,peak_end_date," +
					"peak_count_nu,qw_begin_date,qw_end_date," +
					"qw_count_nu,gw_begin_date,gw_end_date," +
					"gw_count_nu,sv_begin_date,sv_end_date," +
					"sv_count_nu\n");
			while ((inputLine = br.readLine()) != null) {
				try {
					model.fetchDescription(bw, inputLine);
					view.report.append("Done with site " + inputLine + "\n");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					view.report.append("Error! Can't pull description from site " + inputLine + "\n");
				}
			}
			
			bw.close();
			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void fetchData() {
		try {
			String inputLine;

			//save to this filename
			File file = new File("site_data.csv");
			file.createNewFile();
			
			// get cite list from this file
			File citeFile = new File(siteList);
			BufferedReader br = new BufferedReader(new FileReader(citeFile));
			
			//use FileWriter to write file
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("agency_cd,site_no,datetime,00060_00003," +
					"00060_00003_cd,80154_00003," +
					"80154_00003_cd,80155_00003,80155_00003_cd\n");
			while ((inputLine = br.readLine()) != null) {
				try {
					model.fetchData(bw, inputLine);
					view.report.append("Done with site " + inputLine + "\n");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					view.report.append("Error! Can't pull data from site " + inputLine + "\n");
				}
			}
			
			bw.close();
			br.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		Model model = new Model();
		View view = new View();
		Control control = new Control(model, view);
		control.view.chooseFile.doClick();
		control.view.run.doClick();
	}

}
