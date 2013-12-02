package oh.lucas.portal.sacwis.service;

import oh.lucas.portal.LucasAnnotationConstants;
import oh.lucas.portal.sacwis.dto.SacwisDTO;

import org.springframework.stereotype.Service;

@Service(value=LucasAnnotationConstants.SACWIS_SERVICE)
public class SacwisServiceImpl implements SacwisService {

	@Override
	public SacwisDTO searchForm(SacwisDTO dto) {
		return mockData();
	}
	
	private SacwisDTO mockData(){
		
		SacwisDTO searchResult= new SacwisDTO();
		searchResult.setSacwisId("1234");
		searchResult.setSacwisName("Sacwis Name");
		searchResult.setSacwisApproverName( "My Approver");
		return searchResult;
		
	}

}
