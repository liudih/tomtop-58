package com.tomtop.member.services.webservice.rspread;


public class ServiceSoapProxy implements ServiceSoap {
  private String _endpoint = null;
  private ServiceSoap serviceSoap = null;
  
  public ServiceSoapProxy() {
    _initServiceSoapProxy();
  }
  
  public ServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceSoapProxy();
  }
  
  private void _initServiceSoapProxy() {
    try {
      serviceSoap = (new ServiceLocator()).getServiceSoap();
      if (serviceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSoap != null)
      ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ServiceSoap getServiceSoap() {
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap;
  }
  
  public int createCampaignDraft(java.lang.String loginEmail, java.lang.String password, Campaign campaignArgs, java.lang.String[] category, int interval) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createCampaignDraft(loginEmail, password, campaignArgs, category, interval);
  }
  
  public int createCampaign(java.lang.String loginEmail, java.lang.String password, Campaign campaignArgs, java.lang.String[] category, int interval) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createCampaign(loginEmail, password, campaignArgs, category, interval);
  }
  
  public int createCampaign2(java.lang.String loginEmail, java.lang.String password, java.lang.String campaignName, CampaignCreatives[] campaignCreatives, java.lang.String[] category, int interval, java.util.Calendar schedule, java.lang.String signature, CampaignStatus campaignStatus) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createCampaign2(loginEmail, password, campaignName, campaignCreatives, category, interval, schedule, signature, campaignStatus);
  }
  
  public boolean updateCampaignStatus(java.lang.String loginEmail, java.lang.String password, java.lang.String campaignID, CampaignStatus campaignStatus) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.updateCampaignStatus(loginEmail, password, campaignID, campaignStatus);
  }
  
  public int sendSMS(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String SMSContent, java.lang.String sender, java.util.Calendar schedule, CampaignStatus campaignStatus, java.lang.String[] phoneSubscribers, java.lang.String[] category) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.sendSMS(loginEmail, APIKey, SMSContent, sender, schedule, campaignStatus, phoneSubscribers, category);
  }
  
  public CampaignStatus getCampaignStatus(java.lang.String loginEmail, java.lang.String password, int campaignID) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignStatus(loginEmail, password, campaignID);
  }
  
  public CampaignReport getCampaignReport(java.lang.String loginEmail, java.lang.String password, int campaignID) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignReport(loginEmail, password, campaignID);
  }
  
  public void changePublishStatus(java.lang.String loginEmail, java.lang.String password, java.lang.String campaign_id, boolean isPublish) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    serviceSoap.changePublishStatus(loginEmail, password, campaign_id, isPublish);
  }
  
  public GetAllSubscriptionResponseGetAllSubscriptionResult getAllSubscription(java.lang.String loginEmail, java.lang.String password) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getAllSubscription(loginEmail, password);
  }
  
  public GetSubscriptionResponseGetSubscriptionResult getSubscription(java.lang.String loginEmail, java.lang.String password, SubscriptionStatus status) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getSubscription(loginEmail, password, status);
  }
  
  public java.lang.String getSubscriptions2String(java.lang.String loginEmail, java.lang.String password, SubscriptionStatus status) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getSubscriptions2String(loginEmail, password, status);
  }
  
  public GetSubscribersResponseGetSubscribersResult getSubscribers(java.lang.String loginEmail, java.lang.String password, java.lang.String subscription, SubscriberStatus status) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getSubscribers(loginEmail, password, subscription, status);
  }
  
  public boolean createSubscription(java.lang.String loginEmail, java.lang.String password, java.lang.String subscriptionName, java.lang.String description) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createSubscription(loginEmail, password, subscriptionName, description);
  }
  
  public boolean addSubscriberByEmail(java.lang.String loginEmail, java.lang.String password, java.lang.String subscriberEmail, java.lang.String subscription, DoubleOptIn optInType) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.addSubscriberByEmail(loginEmail, password, subscriberEmail, subscription, optInType);
  }
  
  public int deleteSubscribers(java.lang.String loginEmail, java.lang.String password, java.lang.String[] subscriberEmails, java.lang.String subscription) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.deleteSubscribers(loginEmail, password, subscriberEmails, subscription);
  }
  
  public boolean addSubscriberByInfo(java.lang.String loginEmail, java.lang.String password, Subscriber subscriberArgs, java.lang.String subscription, DoubleOptIn optInType) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.addSubscriberByInfo(loginEmail, password, subscriberArgs, subscription, optInType);
  }
  
  public AddSubscribersByInfoResponseAddSubscribersByInfoResult addSubscribersByInfo(java.lang.String loginEmail, java.lang.String password, Subscriber[] subscriberArgs, java.lang.String subscription, DoubleOptIn optInType) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.addSubscribersByInfo(loginEmail, password, subscriberArgs, subscription, optInType);
  }
  
  public java.lang.String send2(java.lang.String loginEmail, java.lang.String password, java.lang.String campaignName, java.lang.String from, java.lang.String fromName, java.lang.String to, java.lang.String subject, java.lang.String body) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.send2(loginEmail, password, campaignName, from, fromName, to, subject, body);
  }
  
  public java.lang.String send3(java.lang.String loginEmail, java.lang.String password, java.lang.String campaignName, java.lang.String from, java.lang.String fromName, java.lang.String to, java.lang.String replyTo, java.lang.String subject, java.lang.String body) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.send3(loginEmail, password, campaignName, from, fromName, to, replyTo, subject, body);
  }
  
  public java.lang.String send(java.lang.String loginEmail, java.lang.String password, java.lang.String from, java.lang.String fromName, java.lang.String to, java.lang.String subject, java.lang.String body) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.send(loginEmail, password, from, fromName, to, subject, body);
  }
  
  public java.lang.String helloWorld() throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.helloWorld();
  }
  
  public Server sendBatch(java.lang.String xml) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.sendBatch(xml);
  }
  
  public int searchContacts(java.lang.String loginEmail, java.lang.String password, java.lang.String criteria, int topN, java.lang.String saveAsList, boolean forceCreate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.searchContacts(loginEmail, password, criteria, topN, saveAsList, forceCreate);
  }
  
  public boolean splitContacts(java.lang.String loginEmail, java.lang.String password, java.lang.String oldListName, java.lang.String saveAsList) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.splitContacts(loginEmail, password, oldListName, saveAsList);
  }
  
  public int excludeContactList(java.lang.String loginEmail, java.lang.String password, java.lang.String campaignName, java.lang.String excludeLists) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.excludeContactList(loginEmail, password, campaignName, excludeLists);
  }
  
  public GetCampaignSentsResponseGetCampaignSentsResult getCampaignSents(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignSents(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public GetCampaignOpensResponseGetCampaignOpensResult getCampaignOpens(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignOpens(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public GetCampaignClicksResponseGetCampaignClicksResult getCampaignClicks(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignClicks(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public GetCampaignUnsubscribesResponseGetCampaignUnsubscribesResult getCampaignUnsubscribes(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignUnsubscribes(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public GetCampaignAbusesResponseGetCampaignAbusesResult getCampaignAbuses(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignAbuses(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public GetCampaignConversionsResponseGetCampaignConversionsResult getCampaignConversions(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignConversions(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public GetCampaignConvertionsResponseGetCampaignConvertionsResult getCampaignConvertions(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignConvertions(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public GetCampaignBouncesResponseGetCampaignBouncesResult getCampaignBounces(java.lang.String loginEmail, java.lang.String password, int campaignID, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignBounces(loginEmail, password, campaignID, startDate, endDate);
  }
  
  public boolean addSenderEmail(java.lang.String loginEmail, java.lang.String password, java.lang.String senderEmail) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.addSenderEmail(loginEmail, password, senderEmail);
  }
  
  public boolean createNewAccount(java.lang.String loginEmail, java.lang.String loginPassword, java.lang.String newAccountName, java.lang.String newAccountEmail, java.lang.String newAccountPassword) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createNewAccount(loginEmail, loginPassword, newAccountName, newAccountEmail, newAccountPassword);
  }
  
  public boolean transferCredit(java.lang.String loginEmail, java.lang.String loginPassword, java.lang.String transferToEmail, int creditCount) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.transferCredit(loginEmail, loginPassword, transferToEmail, creditCount);
  }
  
  public boolean uplodeZipFile(java.lang.String loginEmail, java.lang.String loginPassword, byte[] fileStream, int campaignId) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.uplodeZipFile(loginEmail, loginPassword, fileStream, campaignId);
  }
  
  public java.lang.String uploadContactListFile(java.lang.String loginEmail, java.lang.String loginPassword, java.lang.String fileType, byte[] myFileStream, java.lang.String contactListName) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.uploadContactListFile(loginEmail, loginPassword, fileType, myFileStream, contactListName);
  }
  
  public boolean nameExists(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String accountName) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.nameExists(loginEmail, APIKey, accountName);
  }
  
  public boolean emailExists(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String accountEmail) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.emailExists(loginEmail, APIKey, accountEmail);
  }
  
  public int getCampaignID(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String campaignName) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignID(loginEmail, APIKey, campaignName);
  }
  
  public java.lang.String getAccessToken(java.lang.String loginEmail, java.lang.String APIKey) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getAccessToken(loginEmail, APIKey);
  }
  
  public boolean verifyAccessToken(java.lang.String emailAddress, java.lang.String token) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.verifyAccessToken(emailAddress, token);
  }
  
  public java.lang.String getAPIKey(java.lang.String loginEmail, java.lang.String loginPassword) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getAPIKey(loginEmail, loginPassword);
  }
  
  public GetAccountInfoResponseGetAccountInfoResult getAccountInfo(java.lang.String loginEmail, java.lang.String loginPassword) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getAccountInfo(loginEmail, loginPassword);
  }
  
  public boolean setCampaignDailyLimit(java.lang.String loginEmail, java.lang.String APIKey, int campaignid, int quantity) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.setCampaignDailyLimit(loginEmail, APIKey, campaignid, quantity);
  }
  
  public boolean setCampaignTimeLimit(java.lang.String loginEmail, java.lang.String APIKey, int campaignid, java.lang.String timeSpan) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.setCampaignTimeLimit(loginEmail, APIKey, campaignid, timeSpan);
  }
  
  public boolean splitContactListByRange(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String sourceContactListName, java.lang.String range, java.lang.String targetContactListName) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.splitContactListByRange(loginEmail, APIKey, sourceContactListName, range, targetContactListName);
  }
  
  public int getActiveSubscribersByContactList(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String contactListName) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getActiveSubscribersByContactList(loginEmail, APIKey, contactListName);
  }
  
  public int createCampaignDraftSerialize(java.lang.String loginEmail, java.lang.String password, java.lang.String strcampaignArgs, java.lang.String[] category, int interval) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createCampaignDraftSerialize(loginEmail, password, strcampaignArgs, category, interval);
  }
  
  public int createCampaignSerialize(java.lang.String loginEmail, java.lang.String password, java.lang.String strcampaignArgs, java.lang.String[] category, int interval) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createCampaignSerialize(loginEmail, password, strcampaignArgs, category, interval);
  }
  
  public int createCampaign2Serialize(java.lang.String loginEmail, java.lang.String password, java.lang.String campaignName, java.lang.String strcampaignCreatives, java.lang.String[] category, int interval, java.util.Calendar schedule, java.lang.String signature, CampaignStatus campaignStatus) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.createCampaign2Serialize(loginEmail, password, campaignName, strcampaignCreatives, category, interval, schedule, signature, campaignStatus);
  }
  
  public java.lang.String getCampaignReportSerialize(java.lang.String loginEmail, java.lang.String password, int campaignID) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignReportSerialize(loginEmail, password, campaignID);
  }
  
  public boolean addSubscriberByInfoSerialize(java.lang.String loginEmail, java.lang.String password, java.lang.String strsubscriberArgs, java.lang.String subscription, DoubleOptIn optInType) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.addSubscriberByInfoSerialize(loginEmail, password, strsubscriberArgs, subscription, optInType);
  }
  
  public AddSubscribersByInfoSerializeResponseAddSubscribersByInfoSerializeResult addSubscribersByInfoSerialize(java.lang.String loginEmail, java.lang.String password, java.lang.String strsubscriberArgs, java.lang.String subscription, DoubleOptIn optInType) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.addSubscribersByInfoSerialize(loginEmail, password, strsubscriberArgs, subscription, optInType);
  }
  
  public GetUserSentReportResponseGetUserSentReportResult getUserSentReport(java.lang.String loginEmail, java.lang.String APIKey, AccountType accountType, java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getUserSentReport(loginEmail, APIKey, accountType, startDate, endDate);
  }
  
  public GetUserCreditResponseGetUserCreditResult getUserCredit(java.lang.String loginEmail, java.lang.String APIKey, AccountType accountType) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getUserCredit(loginEmail, APIKey, accountType);
  }
  
  public GetSubscriberDetailResponseGetSubscriberDetailResult getSubscriberDetail(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String subscriber_email) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getSubscriberDetail(loginEmail, APIKey, subscriber_email);
  }
  
  public GetCampaignSubscriberDetailResponseGetCampaignSubscriberDetailResult getCampaignSubscriberDetail(java.lang.String loginEmail, java.lang.String APIKey, java.lang.String subscriber_email, int campaign_id) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCampaignSubscriberDetail(loginEmail, APIKey, subscriber_email, campaign_id);
  }
  
  
}