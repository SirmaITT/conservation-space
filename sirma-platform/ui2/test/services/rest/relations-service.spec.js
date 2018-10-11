import {RelationsService} from 'services/rest/relations-service';
import {HEADER_V2_JSON} from 'services/rest-client';

describe('RelationsService', () => {
  let relationsService;
  let restClient = {basePath: 'basepath'};
  beforeEach(() => {
    relationsService = new RelationsService(restClient);
  });

  it('should use proper service url', () => {
    restClient.post = sinon.spy();
    relationsService.suggest('starId', 'Vader', 'Luke', 'father');

    expect(restClient.post.calledOnce);
    expect(restClient.post.getCall(0).args[0]).to.equal('/relations' + '/suggest');
    expect(restClient.post.getCall(0).args[1].definitionId).to.equal('starId');
    expect(restClient.post.getCall(0).args[1].propertyName).to.equal('Vader');
    expect(restClient.post.getCall(0).args[1].keywords).to.equal('Luke');
    expect(restClient.post.getCall(0).args[2].params.properties).to.equal('father');
    let headers = restClient.post.getCall(0).args[2].headers;
    expect(headers[Object.keys(headers)[0]]).to.equal(HEADER_V2_JSON);
  });

});