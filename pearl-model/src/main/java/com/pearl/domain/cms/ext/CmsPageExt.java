package com.pearl.domain.cms.ext;

import com.pearl.domain.cms.CmsPage;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CmsPageExt extends CmsPage {
    private String htmlValue;

}
