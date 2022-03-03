package edu.kosmo.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BoardVO {
	
	private int bid;			// NOT NULL NUMBER(4)  
	private String bname;		// VARCHAR2(20)  
	private String btitle;		// VARCHAR2(100)
	private String bcontent;	// VARCHAR2(300)
	private Timestamp bdate;	// DATE 
	private int bhit;			// NUMBER(4)
	private int bgroup;			// NUMBER(4)
	private int bstep;			// NUMBER(4)
	private int bindent;		// NUMBER(4)
	

	
}
