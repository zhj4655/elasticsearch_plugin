import grpc
from source import connection_pb2, connection_pb2_grpc


def sendRequest(stub):
    req = []
    req.append(connection_pb2.ConnRequest(request="python request1"))
    req.append(connection_pb2.ConnRequest(request="python request2"))
    req_iterator = req.__iter__()
    resp = stub.Conn(req_iterator)
    for it in resp:
        print it
    # print resp


def run():
    with grpc.insecure_channel('localhost:12345') as channel:
        stub = connection_pb2_grpc.ConnectionStub(channel)
        sendRequest(stub)


if __name__ == '__main__':
    run()