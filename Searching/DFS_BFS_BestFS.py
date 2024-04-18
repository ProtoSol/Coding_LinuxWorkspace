from collections import deque

def bfs(graph, start, target):
    visited = set()
    queue = deque([(start, [start])])

    while queue:
        node, path = queue.popleft()

        if node == target:
            print("Path to", target, ":", ' -> '.join(path))
            return

        if node not in visited:
            visited.add(node)
            for neighbor in graph[node]:
                if neighbor not in visited:
                    queue.append((neighbor, path + [neighbor]))

def dfs(graph, start, target, visited=None, path=None):
    if visited is None:
        visited = set()
    if path is None:
        path = []

    visited.add(start)
    path = path + [start]

    if start == target:
        print("DFS path to", target, ":", ' -> '.join(path))
        return

    for neighbor in graph[start] - visited:
        dfs(graph, neighbor, target, visited, path)
        

import heapq

def best_first_search(graph, start, target, heuristic):
    priority_queue = [(heuristic(start, target), start)]
    visited = set()

    while priority_queue:
        _, current_node = heapq.heappop(priority_queue)

        if current_node == target:
            print("Best-First Search path to", target)
            print(" -> ".join(visited))  # Change 'path' to 'visited'
            return

        if current_node not in visited:
            visited.add(current_node)

            for neighbor in graph[current_node]:
                if neighbor not in visited:
                    priority = heuristic(neighbor, target)
                    heapq.heappush(priority_queue, (priority, neighbor))

    print("Path not found")
            
graph = {
    'A': {'B', 'C'},
    'B': {'A', 'D', 'E'},
    'C': {'A', 'F', 'G'},
    'D': {'B'},
    'E': {'B', 'H'},
    'F': {'C'},
    'G': {'C'},
    'H': {'E'}
}

start_node = 'A'
target_node = 'H'
print("BFS traversal starting from", start_node)
bfs(graph, start_node, target_node)