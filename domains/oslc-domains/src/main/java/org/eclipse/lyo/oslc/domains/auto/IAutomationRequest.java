// Start of user code Copyright
/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Eclipse Distribution License 1.0
 * which is available at http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */
// End of user code

package org.eclipse.lyo.oslc.domains.auto;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRdfCollectionType;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import org.eclipse.lyo.oslc.domains.auto.Oslc_autoDomainConstants;
import org.eclipse.lyo.oslc.domains.auto.Oslc_autoDomainConstants;
import org.eclipse.lyo.oslc.domains.DctermsDomainConstants;
import org.eclipse.lyo.oslc.domains.FoafDomainConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcDomainConstants;
import org.eclipse.lyo.oslc.domains.RdfDomainConstants;
import org.eclipse.lyo.oslc.domains.DctermsVocabularyConstants;
import org.eclipse.lyo.oslc.domains.RdfVocabularyConstants;
import org.eclipse.lyo.oslc.domains.auto.IAutomationPlan;
import org.eclipse.lyo.oslc.domains.auto.IParameterInstance;
import org.eclipse.lyo.oslc.domains.IPerson;
// Start of user code imports
// End of user code

@OslcNamespace(Oslc_autoDomainConstants.AUTOMATIONREQUEST_NAMESPACE)
@OslcName(Oslc_autoDomainConstants.AUTOMATIONREQUEST_LOCALNAME)
@OslcResourceShape(title = "AutomationRequest Resource Shape", describes = Oslc_autoDomainConstants.AUTOMATIONREQUEST_TYPE)
public interface IAutomationRequest
{

    public void addContributor(final Link contributor );
    public void addCreator(final Link creator );
    public void addType(final Link type );
    public void addInstanceShape(final Link instanceShape );
    public void addServiceProvider(final Link serviceProvider );
    public void addState(final Link state );
    public void addInputParameter(final Link inputParameter );

    @OslcName("contributor")
    @OslcPropertyDefinition(DctermsVocabularyConstants.DUBLIN_CORE_NAMSPACE + "contributor")
    @OslcDescription("Contributor or contributors to the resource. It is likely that the target resource will be a foaf:Person but that is not necessarily the case.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({FoafDomainConstants.PERSON_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getContributor();

    @OslcName("created")
    @OslcPropertyDefinition(DctermsVocabularyConstants.DUBLIN_CORE_NAMSPACE + "created")
    @OslcDescription("Timestamp of resource creation")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.DateTime)
    @OslcReadOnly(false)
    public Date getCreated();

    @OslcName("creator")
    @OslcPropertyDefinition(DctermsVocabularyConstants.DUBLIN_CORE_NAMSPACE + "creator")
    @OslcDescription("Creator or creators of the resource. It is likely that the target resource will be a foaf:Person but that is not necessarily the case.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({FoafDomainConstants.PERSON_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getCreator();

    @OslcName("description")
    @OslcPropertyDefinition(DctermsVocabularyConstants.DUBLIN_CORE_NAMSPACE + "description")
    @OslcDescription("Descriptive text about resource represented as rich text in XHTML content. SHOULD include only content that is valid and suitable inside an XHTML <div> element.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.XMLLiteral)
    @OslcReadOnly(false)
    public String getDescription();

    @OslcName("identifier")
    @OslcPropertyDefinition(DctermsVocabularyConstants.DUBLIN_CORE_NAMSPACE + "identifier")
    @OslcDescription("A unique identifier for a resource. Typically read-only and assigned by the service provider when a resource is created. Not typically intended for end-user display.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getIdentifier();

    @OslcName("modified")
    @OslcPropertyDefinition(DctermsVocabularyConstants.DUBLIN_CORE_NAMSPACE + "modified")
    @OslcDescription("Timestamp of latest resource modification")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.DateTime)
    @OslcReadOnly(false)
    public Date getModified();

    @OslcName("type")
    @OslcPropertyDefinition(RdfVocabularyConstants.RDF_NAMSPACE + "type")
    @OslcDescription("The resource type URIs")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public Set<Link> getType();

    @OslcName("title")
    @OslcPropertyDefinition(DctermsVocabularyConstants.DUBLIN_CORE_NAMSPACE + "title")
    @OslcDescription("Title of the resource represented as rich text in XHTML content. SHOULD include only content that is valid inside an XHTML <span> element.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.XMLLiteral)
    @OslcReadOnly(false)
    public String getTitle();

    @OslcName("instanceShape")
    @OslcPropertyDefinition(OslcDomainConstants.OSLC_NAMSPACE + "instanceShape")
    @OslcDescription("The URI of a Resource Shape that describes the possible properties, occurrence, value types, allowed values and labels. This shape information is useful in displaying the subject resource as well as guiding clients in performing modifications. Instance shapes may be specific to the authenticated user associated with the request that retrieved the resource, the current state of the resource and other factors and thus should not be cached.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRepresentation(Representation.Reference)
    @OslcReadOnly(false)
    public Set<Link> getInstanceShape();

    @OslcName("serviceProvider")
    @OslcPropertyDefinition(OslcDomainConstants.OSLC_NAMSPACE + "serviceProvider")
    @OslcDescription("A link to the resource's OSLC Service Provider. There may be cases when the subject resource is available from a service provider that implements multiple domain specifications, which could result in multiple values for this property.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRepresentation(Representation.Reference)
    @OslcReadOnly(false)
    public Set<Link> getServiceProvider();

    @OslcName("state")
    @OslcPropertyDefinition(Oslc_autoDomainConstants.AUTOMATION_NAMSPACE + "state")
    @OslcDescription("Used to indicate the state of the automation request based on values defined by the service provider. Most often a read-only property. It is expected that this will be a resource reference to a definition of a valid automation request state on the service provider.")
    @OslcOccurs(Occurs.OneOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(true)
    public Set<Link> getState();

    @OslcName("desiredState")
    @OslcPropertyDefinition(Oslc_autoDomainConstants.AUTOMATION_NAMSPACE + "desiredState")
    @OslcDescription("Used to indicate the desired state of the Automation Request based on values defined by the service provider. It is expected that this will be a resource reference to a definition of a valid automation request state on the service provider.")
    @OslcOccurs(Occurs.ZeroOrOne)
    @OslcValueType(ValueType.Resource)
    @OslcReadOnly(false)
    public Link getDesiredState();

    @OslcName("inputParameter")
    @OslcPropertyDefinition(Oslc_autoDomainConstants.AUTOMATION_NAMSPACE + "inputParameter")
    @OslcDescription("Parameters provided when Automation Requests are created. These include parameters provided by the creator of the Automation Request (whether by delegated UI or HTTP POST) and MAY include additional parameters added by the service provider during Automation Request creation. See the definition of the oslc_auto:parameterDefinition attribute of the Automation Plan for additional guidance on determining which parameters are required. Creators of Automation Requests MAY provide parameters beyond those defined in the Automation Plan without guarantee the service provider will recognize or honor them. It is expected that this attribute is write-able on Automation Request creation and read-only thereafter.")
    @OslcOccurs(Occurs.ZeroOrMany)
    @OslcValueType(ValueType.Resource)
    @OslcRange({Oslc_autoDomainConstants.PARAMETERINSTANCE_TYPE})
    @OslcReadOnly(false)
    public Set<Link> getInputParameter();

    @OslcName("executesAutomationPlan")
    @OslcPropertyDefinition(Oslc_autoDomainConstants.AUTOMATION_NAMSPACE + "executesAutomationPlan")
    @OslcDescription("Automation Plan run by the Automation Request. It is likely that the target resource will be an oslc_auto:AutomationPlan but that is not necessarily the case.")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRepresentation(Representation.Reference)
    @OslcRange({Oslc_autoDomainConstants.AUTOMATIONPLAN_TYPE})
    @OslcReadOnly(false)
    public Link getExecutesAutomationPlan();


    public void setContributor(final Set<Link> contributor );
    public void setCreated(final Date created );
    public void setCreator(final Set<Link> creator );
    public void setDescription(final String description );
    public void setIdentifier(final String identifier );
    public void setModified(final Date modified );
    public void setType(final Set<Link> type );
    public void setTitle(final String title );
    public void setInstanceShape(final Set<Link> instanceShape );
    public void setServiceProvider(final Set<Link> serviceProvider );
    public void setState(final Set<Link> state );
    public void setDesiredState(final Link desiredState );
    public void setInputParameter(final Set<Link> inputParameter );
    public void setExecutesAutomationPlan(final Link executesAutomationPlan );
}

